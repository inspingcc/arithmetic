package main.java.com.houshanping.juc.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

/**
 * @Author: houshanping
 * @Date: 2020/03/02 15:37
 */
public class NettyClient {
    static int num = 0;
    static Channel channel;

    public static void main(String[] args) {
        EventLoopGroup workGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast("stringEncode", new StringEncoder());
                        socketChannel.pipeline().addLast("stringDecode", new StringDecoder());
                    }
                });
        ChannelFuture channelFuture = bootstrap.connect(new InetSocketAddress(9051));
        channelFuture.addListener((future -> {
            if (future.isSuccess()) {
                channel = channelFuture.channel();
                System.out.println("连接建立成功");
//                new Thread(() -> {
//                    while (true) {
//                        if (!channel.isActive()) {
//                            System.out.println("连接中断~");
//                            break;
//                        }
//                        channel.writeAndFlush("你好 我是客户端!" + num++);
//                        System.out.println("发送成功,num:" + num);
//                        try {
//                            if (num % 10 == 0) {
//                                Thread.sleep(30000);
//                            } else {
//                                Thread.sleep(1000);
//                            }
//                        } catch (Exception e) {
//                            System.out.println(e.fillInStackTrace());
//                        }
//                    }
//                }).start();
                sendMessage2Server();
            }
        }));
    }

    public static void sendMessage2Server() throws Exception {
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String message = bufferedReader.readLine();
            if (message.indexOf("exit") != -1) {
                return;
            }
            System.out.println("正在发送消息:" + message);
            if (channel.isActive()) {
                channel.writeAndFlush(message);
            }
        }
    }
}
