package com.jsrdxzw.netty.im;

import com.jsrdxzw.netty.chapter3.LoginRequestPacket;
import com.jsrdxzw.netty.chapter3.Packet;
import com.jsrdxzw.netty.chapter3.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author xuzhiwei
 * @date 2020-04-23
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf requestByteBuf = (ByteBuf) msg;
        Packet packet = PacketCodeC.INSTANCE.decode(requestByteBuf);

        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        if (packet instanceof LoginRequestPacket) {
            LoginRequestPacket loginRequestPacket = (LoginRequestPacket) packet;
            // 登录校验
            if (valid(loginRequestPacket)) {
                System.out.println("校验成功");
                loginResponsePacket.setSuccess(true);
                // 校验成功
            } else {
                System.out.println("校验失败");
                loginResponsePacket.setSuccess(false);
                loginResponsePacket.setReason("校验失败,账号或者密码错误");
                // 校验失败
            }
        }

        ByteBuf encode = PacketCodeC.INSTANCE.encode(ctx.alloc(), loginResponsePacket);
        ctx.channel().writeAndFlush(encode);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return false;
    }
}
