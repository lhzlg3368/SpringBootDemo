package com.jesse.spring.controller;

import com.jesse.spring.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Map<String,Object> hello(){
        Result result = new Result();
        result.setResults("test");
        return result.toMap();
    }

}
