package org.frank.spring.cloud.order.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.internal.Nullable;

import javax.validation.constraints.NotNull;
import java.io.IOException;

public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Nullable
    public static<T> T parseObject(@NotNull String jsonStr, Class<T> clazz){
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (IOException e) {            
            return null;
        }
    }
}
