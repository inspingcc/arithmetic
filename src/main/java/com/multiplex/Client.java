package com.multiplex;


import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Author: houshanping
 * @Date: 2020/03/05 9:31
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(9051));
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        new Thread(() -> {
//            while (true) {
            int readLen;
            int maxLen = 2048;
//                StringBuffer serverMessage = new StringBuffer();
            byte[] messageBytes = new byte[maxLen];
            try {
                while ((readLen = inputStream.read(messageBytes)) != -1) {
//                        serverMessage.append();
                    System.out.println(new String(messageBytes, 0, readLen));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
//            }
        }).start();
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String message = bufferedReader.readLine();
            if (message.indexOf("exit") != -1) {
                System.out.println("当前客户端退出");
                return;
            }
            outputStream.write(message.getBytes());
        }
    }
}
