package com.oak.sysbase.controller;

import com.alibaba.fastjson2.JSONObject;
import com.oak.sysbase.pojo.testPojo;
import com.oak.sysbase.service.testnestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class testnestController {

    @Autowired
    testnestService testnestService;

    @CrossOrigin
    @PostMapping("/infoTest")
    @ResponseBody
    public JSONObject test(@RequestBody testPojo testPojo){
        System.out.println("Controller Test");
        return testnestService.getEngineMesasge(testPojo);
    }
}
