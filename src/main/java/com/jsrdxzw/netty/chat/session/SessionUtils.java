package com.jsrdxzw.netty.chat.session;

import com.jsrdxzw.netty.chat.attributes.Attributes;
import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuzhiwei
 * @date 2020-04-29
 */
public class SessionUtils {
    private static final Map<String, Channel> userChannelMap = new ConcurrentHashMap<>();

    public static void bindSession(Session session, Channel channel) {
        userChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unbindSession(Session session, Channel channel) {
        if (hasLogin(channel)) {
            userChannelMap.remove(getSession(channel).getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }
    }

    public static boolean hasLogin(Channel channel) {
        return channel.hasAttr(Attributes.SESSION);
    }

    public static Session getSession(Channel channel) {
        return channel.attr(Attributes.SESSION).get();
    }
}
