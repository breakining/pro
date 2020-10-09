package com.ghw.base.core.domain;

import io.swagger.annotations.ApiParam;

import java.util.List;

/**
 * @Description: 简单前台转换结果对象
 * @Refrence: ghw
 * @Date: 2019/6/29 10:12
 * @Modify:
 **/
public class ResultBean<Obj> {

    @ApiParam("消息码")
    private String code;

    @ApiParam("操作消息")
    private String message;

    @ApiParam("List结果集")
    private List<Obj> resultList;

    @ApiParam("单个结果")
    private Obj resultObject;

    public ResultBean() {
    }

    public ResultBean(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultBean(String code, List<Obj> resultList) {
        this.code = code;
        this.resultList = resultList;
    }

    public ResultBean(String code, Obj resultObject) {
        this.code = code;
        this.resultObject = resultObject;
    }

    public ResultBean(String code, String message, List<Obj> resultList) {
        this.code = code;
        this.message = message;
        this.resultList = resultList;
    }

    public ResultBean(String code, String message, Obj resultObject) {
        this.code = code;
        this.message = message;
        this.resultObject = resultObject;
    }

    public boolean isSuccess() {
        if ("1".equals(this.code)) {
            return true;
        }
        return false;
    }

    public List<Obj> getResultList() {
        return resultList;
    }

    public ResultBean<Obj> setResultList(List<Obj> resultList) {
        this.resultList = resultList;
        return this;
    }

    public Obj getResultObject() {
        return resultObject;
    }

    public ResultBean<Obj> setResultObject(Obj resultObject) {
        this.resultObject = resultObject;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResultBean error(String message) {
        ResultBean r = new ResultBean("0", message);
        return r;
    }

    public static ResultBean ok(String message) {
        ResultBean r = new ResultBean("1", message);
        return r;
    }
}
