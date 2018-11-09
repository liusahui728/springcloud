package org.com.app.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    public static JSONObject getJsonObject() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String data = request.getParameter("data");
        JSONObject jsonObject = JSONObject.parseObject(data);
        return jsonObject;
    }
}
