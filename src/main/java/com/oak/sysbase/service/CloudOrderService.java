package com.oak.sysbase.service;

import com.alibaba.fastjson2.JSONObject;
import com.oak.sysbase.model.Order;
import com.oak.sysbase.pojo.OrderPojo;
import com.oak.sysbase.pojo.testPojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(url = "${Nest.url}",name="OrderClient")
public interface CloudOrderService {

//    拉取待审核订单   待修改url
    @RequestMapping(value = "/order/findUnAuditOrder", method = RequestMethod.POST, consumes = "application/json")
    public OrderPojo[] getunAuditOrder();

//    更新云数据库订单 更新time与state
    @RequestMapping(value = "/order/AuditingOrder", method = RequestMethod.POST, consumes = "application/json")
    public OrderPojo[] updateOrder(@RequestBody List<Order> orders);

}
