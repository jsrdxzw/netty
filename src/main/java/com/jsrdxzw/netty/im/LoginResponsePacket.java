package com.jsrdxzw.netty.im;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsrdxzw.netty.chapter3.Packet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static com.jsrdxzw.netty.im.Command.LOGIN_RESPONSE;

/**
 * @author xuzhiwei
 * @date 2020-04-23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponsePacket extends Packet {

    private boolean success;

    private String reason;

    @JsonIgnore
    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
