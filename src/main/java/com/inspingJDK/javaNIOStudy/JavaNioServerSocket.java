package com.inspingJDK.javaNIOStudy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: houshanping
 * @Date: 2020/02/27 16:36
 */
public class JavaNioServerSocket {

    public static Object xWait = new Object();

//    public static void main(String[] args) throws Exception {
//        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//        serverSocketChannel.configureBlocking(false);
//
//        ServerSocket serverSocket = serverSocketChannel.socket();
//        serverSocket.setReuseAddress(true);
//        serverSocket.bind(new InetSocketAddress(9050));
//
//        Selector selector = Selector.open();
//        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//        while (true) {
//            if (selector.select(100) == 0) {
//                continue;
//            }
//            Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
//            while (selectionKeys.hasNext()) {
//                SelectionKey readyKey = selectionKeys.next();
//                selectionKeys.remove();
//
//                SelectableChannel selectableChannel = readyKey.channel();
//                if (readyKey.isValid() && readyKey.isAcceptable()) {
//                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectableChannel;
//                    SocketChannel socketChannel = serverSocketChannel1.accept();
//                    socketChannel.configureBlocking(false);
//                    socketChannel.register(selector, SelectionKey.OP_READ);
//                } else if (readyKey.isValid() && readyKey.isConnectable()) {
//                    // ...
//                } else if (readyKey.isValid() && readyKey.isReadable()) {
//                    readSocketChannel(readyKey);
//                }
//            }
//        }
//    }
//
//    public static void readSocketChannel(SelectionKey readyKey) {
//
//    }

    // 阻塞同步IO
    public static void startBlockingIO() throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9050));
        try {
            while (true) {
                Socket socket = serverSocket.accept();

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                int maxLen = 2048;
                byte[] messageBytes = new byte[maxLen];
                StringBuffer message = new StringBuffer();
                int readLen;
                while ((readLen = inputStream.read(messageBytes, 0, maxLen)) != -1) {
                    message.append(new String(messageBytes, 0, readLen));
                    if (message.indexOf("over") != -1) {
                        break;
                    }
                }
                System.out.println("服务器来自端口(" + socket.getPort() + ")的消息:" + message);
                outputStream.write("回复消息~".getBytes());

                outputStream.close();
                inputStream.close();
                socket.close();
            }
        } finally {
            serverSocket.close();
        }
    }

    // 非阻塞同步IO accept非阻塞 read阻塞
    public static void startNonblockingIO() throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9050));
        serverSocket.setSoTimeout(100);
        try {
            while (true) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                } catch (SocketTimeoutException e) {
                    //TODO 100ms后继续做别的操作
                    synchronized (JavaNioServerSocket.xWait) {
                        xWait.wait(10);
                    }
                }
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                int readLen, maxLen = 2048;
                byte[] messageBytes = new byte[maxLen];
                StringBuffer message = new StringBuffer();
                while ((readLen = inputStream.read(messageBytes, 0, maxLen)) != -1) {
                    message.append(new String(messageBytes, 0, readLen));
                }
                System.out.println("收到服务器端口为:" + socket.getPort() + "的消息:" + message);
                outputStream.write("回复消息~".getBytes());

                outputStream.close();
                inputStream.close();
                socket.close();
            }

        } finally {
            serverSocket.close();
        }
    }

    // 非阻塞同步IO accept非阻塞 read非阻塞
    public static void startNonblockingIO2() throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9050));
        serverSocket.setSoTimeout(100);
        try {
            while (true) {
                Socket socket = null;
                try {
                    socket = serverSocket.accept();
                } catch (SocketTimeoutException ex) {
                    synchronized (xWait) {
                        System.out.println("执行操作X(10ms)");
                        xWait.wait(10);
                    }
                }
                socket.setSoTimeout(10);

                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                int readLen, maxLen = 2048;
                byte[] messageBytes = new byte[maxLen];
                StringBuffer message = new StringBuffer();
                IOREAD:
                while (true) {
                    try {
                        while ((readLen = inputStream.read(messageBytes, 0, maxLen)) != -1) {
                            message.append(new String(messageBytes, 0, readLen));
                            if (message.indexOf("over") != -1) {
                                break IOREAD;
                            }
                        }
                    } catch (SocketTimeoutException ex) {
                        System.out.println("执行操作Y(10ms)");
                    }
                }

                outputStream.close();
                inputStream.close();
                socket.close();
            }
        } finally {
            serverSocket.close();
        }
    }

    // 多路复用IO Java NIO
    public static void javaNio() throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress(9050));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        try {
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
                        // 连接
                        ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectableChannel;
                        SocketChannel socketChannel = serverSocketChannel1.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(50));
                    } else if (selectionKey.isValid() && selectionKey.isConnectable()) {

                    } else if (selectionKey.isValid() && selectionKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) selectableChannel;
                        ByteBuffer contentBytes = (ByteBuffer) selectionKey.attachment();
                        StringBuffer message = new StringBuffer();
                        int readLen;
                        while ((readLen = socketChannel.read(contentBytes)) != -1) {
                            contentBytes.flip();
                            int position = contentBytes.position();
                            int capacity = contentBytes.capacity();
                            byte[] messageBytes = new byte[capacity];
                            contentBytes.get(messageBytes, position, readLen);
                            message.append(new String(messageBytes));

                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocketChannel.close();
        }
    }

    public static void nioSelector() throws Exception {
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
                    // accept
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectableChannel;
                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(50));
                } else if (selectionKey.isValid() && selectionKey.isReadable()) {
                    // read
                    readChannel(selectionKey);
                }
            }
        }
    }

    public static Map<Integer, StringBuffer> MESSAGE_ALL = new ConcurrentHashMap<>();

    public static void readChannel(SelectionKey readKey) throws IOException {
        SocketChannel clientSocketChannel = (SocketChannel) readKey.channel();
        ByteBuffer messageBytes = (ByteBuffer) readKey.attachment();
        StringBuffer message = new StringBuffer();
        int readLen;
        while ((readLen = clientSocketChannel.read(messageBytes)) != 0) {
            messageBytes.flip();
            int position = messageBytes.position();
            int capacity = messageBytes.capacity();
            byte[] bytes = new byte[capacity];
            messageBytes.get(bytes, position, readLen);
            message.append(new String(bytes));
            messageBytes.clear();
        }
        Integer hashCode = clientSocketChannel.hashCode();
        // 当前消息完整
        StringBuffer competedMessage;
        StringBuffer historyMessage = MESSAGE_ALL.remove(hashCode);
        if (historyMessage == null) {
            competedMessage = message;
        } else {
            competedMessage = historyMessage.append(message);
        }
        if (message.indexOf("over") != -1) {
            //TODO 做业务逻辑
            System.out.println("服务器收到客户端(" + hashCode + ")的消息:" + competedMessage);
            //回复客户端
            ByteBuffer writeMsg = ByteBuffer.wrap("收到".getBytes());
            clientSocketChannel.write(writeMsg);
            clientSocketChannel.close();
        } else {
            MESSAGE_ALL.put(hashCode, competedMessage);
            System.out.println("服务器收到客户端(" + hashCode + ")的不完整的消息:" + competedMessage);
        }
    }

    public static void main(String[] args) {
        try {
            nioSelector();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
