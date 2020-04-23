package com.jsrdxzw.netty.chapter3;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

/**
 * @author xuzhiwei
 * @date 2020-04-23
 */
public class JSONSerializer implements Serializer {

    private static final byte JSON = 1;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public byte getSerializerAlgorithm() {
        return JSON;
    }

    @SneakyThrows
    @Override
    public byte[] serialize(Object object) {
        return MAPPER.writeValueAsBytes(object);
    }

    @SneakyThrows
    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return MAPPER.readValue(bytes, clazz);
    }
}
