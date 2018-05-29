package com.jesse.spring.controller;

import com.jesse.spring.entity.Result;
import com.jesse.spring.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private CopyService copyService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Map<String, Object> hello() {
        Result result = new Result();
        return result.toMap();
    }

    @RequestMapping(value = "/code",method = RequestMethod.GET)
    public Map<String, Object> h() {
        Result result = new Result();
        String s = copyService.generatingUniqueValidVerificationCode();
        result.setResults(s);
        return result.toMap();
    }
}
