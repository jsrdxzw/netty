package com.jsrdxzw.netty.chapter3;

import lombok.*;

/**
 * @author xuzhiwei
 * @date 2020-04-23
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginRequestPacket extends Packet {

    public static final Byte LOGIN_REQUEST = 1;

    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }

}
