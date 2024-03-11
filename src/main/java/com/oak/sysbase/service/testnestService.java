package com.oak.sysbase.service;

import com.alibaba.fastjson2.JSONObject;
import com.oak.sysbase.pojo.testPojo;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(url = "${Nest.url}",name="demoClient")
public interface testnestService {

    @RequestMapping(value = "/user/signIn", method = RequestMethod.POST, consumes = "application/json")
    public JSONObject getEngineMesasge(@RequestBody testPojo testPojo);
}
