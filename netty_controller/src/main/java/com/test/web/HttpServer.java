package com.test.web;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;


/**
 * @author: liuyang
 * @Date: 18-10-24 11:24
 * @Description:
 */
public class HttpServer {

    public void start(int port) throws Exception {

        //创建线程池
        EventLoopGroup bossGroup = new NioEventLoopGroup(2);
        EventLoopGroup workerGroup = new NioEventLoopGroup(4);
        try {
            //创建路由实例
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    //使用Nio模式并基于套接字socket的方式传输
                    .channel(NioServerSocketChannel.class)
                    //创建初始化其中通道类型是SocketChannel
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            System.out.println("initChannel ch:" + ch);

                            ch.pipeline()
                                    // server端发送的是httpResponse，所以要使用HttpResponseEncoder进行编码
                                    .addLast("encoder", new HttpResponseEncoder())
                                    // server端接收到的是httpRequest，所以要使用HttpRequestDecoder进行解码
                                    .addLast("decoder", new HttpRequestDecoder())
                                    // Http消息组装（封装）
                                    .addLast("aggregator", new HttpObjectAggregator(512 * 1024))
                                    //最终处理业务的handler（业务类）
                                    .addLast("handler", new HttpHandler());

                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);

            //绑定端口
            ChannelFuture f = b.bind(port).sync();
            //绑定IP后，就只能访问指定的IP，当然这只是针对一台电脑有多个网卡的情况
            //b.bind(IP,PORT).sync();

            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        HttpServer server = new HttpServer();
        server.start(8844);

    }
}
