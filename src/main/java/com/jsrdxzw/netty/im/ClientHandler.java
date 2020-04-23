package com.jsrdxzw.netty.im;

import com.jsrdxzw.netty.chapter3.LoginRequestPacket;
import com.jsrdxzw.netty.chapter3.Packet;
import com.jsrdxzw.netty.chapter3.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;
import java.util.UUID;

/**
 * @author xuzhiwei
 * @date 2020-04-23
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(new Date() + ": 客户端开始登录");

        // 创建登录对象
        LoginRequestPacket loginRequestPacket = LoginRequestPacket.builder()
                .userId(UUID.randomUUID().toString())
                .username("flash")
                .password("pwd")
                .build();
        ByteBuf encode = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginRequestPacket);
        ctx.channel().writeAndFlush(encode);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(byteBuf);
        if (packet instanceof LoginResponsePacket) {
            LoginResponsePacket loginResponsePacket = (LoginResponsePacket) packet;
            if (loginResponsePacket.isSuccess()) {
                System.out.println(new Date() + ": 客户端登录成功");
            } else {
                System.out.println(new Date() + ": 客户端登录失败，原因：" + loginResponsePacket.getReason());
            }
        }
    }
}
