package com.ghw.base.core.domain;

import java.util.HashMap;
import java.util.Map;

public class ResponseResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public ResponseResult() {
        put("code", "1");
        put("message", "操作成功");
    }

    public static ResponseResult error() {
        return error("0", "未知异常，请联系管理员");
    }

    public static ResponseResult error(String msg) {
        return error("0", msg);
    }

    public static ResponseResult error(String code, String message) {
        ResponseResult r = new ResponseResult();
        r.put("code", code);
        r.put("message", message);
        return r;
    }

    public static ResponseResult ok(String msg) {
        ResponseResult r = new ResponseResult();
        r.put("message", msg);
        return r;
    }

    public static ResponseResult ok(Map<String, Object> map) {
        ResponseResult r = new ResponseResult();
        r.putAll(map);
        return r;
    }

    public static ResponseResult ok() {
        return new ResponseResult();
    }

    public ResponseResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
