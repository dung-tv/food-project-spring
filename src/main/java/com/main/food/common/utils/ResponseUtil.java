package com.main.food.common.utils;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ResponseUtil {

    public static void out(HttpServletResponse response, Map<String, Object> resultMap) {

        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(Integer.parseInt(resultMap.get("code").toString()));
            response.getOutputStream().write(new Gson().toJson(resultMap).getBytes());
            throw new IOException("olala");
        } catch (Exception e) {
            log.error(e + "，Error JSON");
        }
    }

    public static Map<String, Object> resultMap(boolean flag, Integer code, String msg) {

        return resultMap(flag, code, msg, null);
    }

    public static Map<String, Object> resultMap(boolean flag, Integer code, String msg, Object data) {

        Map<String, Object> resultMap = new HashMap<String, Object>(16);
        resultMap.put("success", flag);
        resultMap.put("message", msg);
        resultMap.put("code", code);
        resultMap.put("timestamp", System.currentTimeMillis());
        if (data != null) {
            resultMap.put("result", data);
        }
        return resultMap;
    }
}
