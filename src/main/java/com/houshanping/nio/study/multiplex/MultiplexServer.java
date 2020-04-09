package main.java.com.houshanping.nio.study.multiplex;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: houshanping
 * @Date: 2020/03/05 9:31
 */
public class MultiplexServer {
    public static Map<Integer, SocketChannel> clientMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress(9051));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            if (selector.select(100) == -1) {
                continue;
            }

            Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
            while (selectionKeys.hasNext()) {
                SelectionKey selectionKey = selectionKeys.next();
                selectionKeys.remove();

                SelectableChannel selectableChannel = selectionKey.channel();
                if (selectionKey.isValid() && selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectableChannel;
                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(50));
                    int hashCode = socketChannel.hashCode();
                    clientMap.put(hashCode, socketChannel);
                    System.out.println("客户端(" + hashCode + "):上线了");
                } else if (selectionKey.isValid() && selectionKey.isReadable()) {
                    SocketChannel clientChannel = (SocketChannel) selectableChannel;
                    // 保存客户端的链接
                    int hashCode = clientChannel.hashCode();
                    ByteBuffer messageBytes = (ByteBuffer) selectionKey.attachment();
                    StringBuffer message = new StringBuffer();
                    int readLen;
                    while ((readLen = clientChannel.read(messageBytes)) != 0) {
                        messageBytes.flip();
                        int position = messageBytes.position();
                        int capacity = messageBytes.capacity();
                        byte[] bytes = new byte[capacity];
                        messageBytes.get(bytes, position, readLen);
                        message.append(new String(bytes));
                        messageBytes.clear();
                    }
                    System.out.println("服务器收到(" + hashCode + ")的消息:" + message);
                    sendMessage2AllClient("客户端" + hashCode + ":" + message);
                }
            }
        }
    }

    public static void sendMessage2AllClient(String message) {
        for (SocketChannel socketChannel : clientMap.values()) {
            if (socketChannel != null && socketChannel.isOpen()) {
                try {
                    socketChannel.write(ByteBuffer.wrap(message.getBytes()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
