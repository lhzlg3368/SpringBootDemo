package com.jesse.spring.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 控制器返回json的实体类
 * 直接调用需要的方法
 * 默认值：
 * state:true,
 * error:"",
 * result:"{}"
 */
public class Result {
    private Object states;
    private String error;
    private Object results;

    public Result() {

    }

    public Result(Object states, String error, Object results) {
        this.states = states;
        this.error = error;
        this.results = results;
    }

    public Result(Object states, Object results) {
        this.states = states;
        this.results = results;
    }

    public Object getStates() {
        return states;
    }

    public void setStates(boolean states) {
        this.states = states;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }

    /**
     * 将实体类转换成Map<String , Object>
     *
     * @return
     */
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("states", states == null ? true : states);
        map.put("error", error == null ? "" : error);
        map.put("results", results == null ? "{}" : results);
        return map;
    }

    @Override
    public String toString() {
        return "Result{" +
                "states='" + states + '\'' +
                ", error='" + error + '\'' +
                ", results='" + results + '\'' +
                '}';
    }
}
