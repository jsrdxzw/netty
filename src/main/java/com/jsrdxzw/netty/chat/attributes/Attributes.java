package com.jsrdxzw.netty.chat.attributes;

import com.jsrdxzw.netty.chat.session.Session;
import io.netty.util.AttributeKey;

/**
 * @author xuzhiwei
 * @date 2020-04-29
 */
public interface Attributes {
    AttributeKey<Boolean> LOGIN = AttributeKey.newInstance("login");
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
