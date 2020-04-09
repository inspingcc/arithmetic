package main.java.com.houshanping.juc.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @Author: houshanping
 * @Date: 2020/03/02 15:37
 */
public class NettyServer {

    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast("idleState", new IdleStateHandler(10, 0, 0, TimeUnit.SECONDS));
                            socketChannel.pipeline().addLast("idleHandler", new IdleHandler());
                            socketChannel.pipeline().addLast("stringDecoder", new StringDecoder());
                            socketChannel.pipeline().addLast("stringEncoder", new StringEncoder());
                            socketChannel.pipeline().addLast("logicHandler", new LogicHandler());
                        }
                    });
            serverBootstrap.bind(9051).sync().addListener((future -> {
                if (future.isSuccess()) {
                    System.out.println("服务器启动成功~");
                } else {
                    System.out.println("失败失败~");
                }
            }));
        } catch (Exception e) {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static class IdleHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
            if (evt instanceof IdleStateEvent) {
                if (((IdleStateEvent)evt).state().equals(IdleState.READER_IDLE)) {
                    System.out.println("读超时中断当前channel");
                    ctx.channel().close();
                }
            } else {
                ctx.fireUserEventTriggered(evt);
            }
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//            super.channelInactive(ctx);
            System.out.println("chanel 不活跃了 中断当前channel");
            ctx.channel().close();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//            super.exceptionCaught(ctx, cause);
            System.out.println("异常中断当前channel,cause:" + cause.toString());
            ctx.channel().close();
        }
    }

    public static class LogicHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            if (msg instanceof String) {
                System.out.println("服务器接收到消息:" + msg.toString());
            }
        }
    }
}
