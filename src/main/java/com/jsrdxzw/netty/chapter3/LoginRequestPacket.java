package com.jsrdxzw.netty.chapter3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import static com.jsrdxzw.netty.im.Command.LOGIN_REQUEST;

/**
 * @author xuzhiwei
 * @date 2020-04-23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestPacket extends Packet {

    private String userId;

    private String username;

    private String password;

    @JsonIgnore
    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }

}
