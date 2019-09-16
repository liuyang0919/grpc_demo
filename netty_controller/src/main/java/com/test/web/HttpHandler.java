package com.test.web;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.net.URLDecoder;

/**
 * @author: liuyang
 * @Date: 18-10-24 11:26
 * @Description:
 */
public class HttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private HttpRequest request;

    /**
     * 5.0之后方法名是 messageReceived
     */
    @Override
    public void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg)
            throws Exception {
        if (msg instanceof HttpRequest) {
            request = msg;

            //URLDecode解码
            String uri = URLDecoder.decode(request.uri(),"UTF-8");
            System.out.println("Uri:" + uri);
        }
        if (msg instanceof HttpContent) {

            HelloWorldClient client = new HelloWorldClient("127.0.0.1", 50051);
            String user = "world";
            long time = System.currentTimeMillis();
            System.out.println(time);
            String res = client.greet(user);
            System.out.println(System.currentTimeMillis() - time);
            client.shutdown();
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(res.getBytes("UTF-8")));
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, String.valueOf(response.content().readableBytes()));
            response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            ctx.write(response);
            ctx.flush();
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelReadComplete");
        super.channelReadComplete(ctx);
        ctx.flush(); // 4
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("exceptionCaught");
        if (null != cause) cause.printStackTrace();
        if (null != ctx) ctx.close();
    }

}
