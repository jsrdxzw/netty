package com.jsrdxzw.netty.chapter3;

import lombok.Data;

/**
 * @author xuzhiwei
 * @date 2020-04-23
 */
@Data
public abstract class Packet {
    private Byte version = 1;

    /**
     * 指令
     *
     * @return
     */
    public abstract Byte getCommand();
}
