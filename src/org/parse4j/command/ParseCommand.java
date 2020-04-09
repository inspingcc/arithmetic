package org.parse4j.command;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.parse4j.Parse;
import org.parse4j.ParseException;
import org.parse4j.ParseUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.parse4j.ParseConstants.*;

public abstract class ParseCommand {

	private static Logger LOGGER = LoggerFactory.getLogger(ParseCommand.class);

	private static RequestConfig config;
	protected JSONObject data = new JSONObject();
	protected boolean addJson = true;

	static {
		config = RequestConfig.custom().build();
	}

	abstract HttpRequestBase getRequest() throws IOException;

	public ParseResponse perform() throws ParseException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Data to be sent: {}", data);
		}

		try {
			long commandStart = System.currentTimeMillis();
            HttpClient httpclient = createSingleClient();
			HttpResponse httpResponse = httpclient.execute(getRequest());
			ParseResponse response = new ParseResponse(httpResponse);

//			CloseableHttpAsyncClient httpclient = createAsyncClient();
//			httpclient.execute(getRequest(),null);
//			ParseResponse response = null;

			long commandReceived = System.currentTimeMillis();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("ParseCommand took "
						+ (commandReceived - commandStart) + " milliseconds\n");
			}
			return response;
		} catch (ClientProtocolException e) {
			throw ParseResponse.getConnectionFailedException(e.getMessage());
		} catch (IOException e) {
			throw ParseResponse.getConnectionFailedException(e.getMessage());
		}
	}

	protected HttpClient createSingleClient() {
		HttpClientBuilder client = HttpClients.custom()
				.setDefaultRequestConfig(config);

		return client.build();
	}

	protected CloseableHttpAsyncClient createAsyncClient() throws IOReactorException {
		IOReactorConfig ioReactorConfig = IOReactorConfig.custom().setSoKeepAlive(true).build();
		ConnectingIOReactor ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);
		PoolingNHttpClientConnectionManager cm =
				new PoolingNHttpClientConnectionManager(ioReactor);
		cm.setMaxTotal(100);
		cm.setDefaultMaxPerRoute(100);
		CloseableHttpAsyncClient client =
				HttpAsyncClients.custom().setConnectionManager(cm).build();
		client.start();
		return client;
	}

	protected void setupHeaders(HttpRequestBase requestBase, boolean addJson) {
		requestBase.addHeader(HEADER_APPLICATION_ID, Parse.getApplicationId());

		if (Parse.isIsRootMode()) {
			requestBase.addHeader(HEADER_MASTER_KEY, Parse.getMasterKey());
		} else {
			requestBase.addHeader(HEADER_REST_API_KEY, Parse.getRestAPIKey());
		}

		if (addJson) {
			requestBase.addHeader(HEADER_CONTENT_TYPE, CONTENT_TYPE_JSON);
		}

		if (data.has(FIELD_SESSION_TOKEN)) {
			requestBase.addHeader(HEADER_SESSION_TOKEN,
					data.getString(FIELD_SESSION_TOKEN));
		} else if (ParseUser.currentUser != null) {
			// if we are logged in, pass the session token
			requestBase.addHeader(HEADER_SESSION_TOKEN,
					ParseUser.currentUser.getSessionToken());
		}
	}

	public void setData(JSONObject data) {
		this.data.put("data", data);
	}

	public void put(String key, String value) {
		this.data.put(key, value);
	}

	public void put(String key, int value) {
		this.data.put(key, value);
	}

	public void put(String key, long value) {
		this.data.put(key, value);
	}

	public void put(String key, JSONObject value) {
		this.data.put(key, value);
	}

	public void put(String key, JSONArray value) {
		this.data.put(key, value);
	}

}
