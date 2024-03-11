package com.oak.sysbase.controller;

import com.alibaba.fastjson2.JSONObject;
import com.oak.sysbase.model.Order;
import com.oak.sysbase.pojo.OrderPojo;
import com.oak.sysbase.service.CloudOrderService;
import com.oak.sysbase.service.SybaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    CloudOrderService cloudOrderService;
    @Autowired
    SybaseOrderService sybaseOrderService;

//    获取未审核订单
    @CrossOrigin
    @PostMapping("/UnAudit")
    @ResponseBody
    public OrderPojo[] UnAuditCloudOrder(){
        return cloudOrderService.getunAuditOrder();
    }

//    审核订单---更新本地sybase与云mysql订单信息
    @Transactional
    @CrossOrigin
    @PostMapping("/Auditing")
    @ResponseBody
    public void AuditOrder(@RequestBody List<Order> orders){
//        设置已审核状态
        for (Order order:orders){
            order.setStateid(2);
            order.setUpdatetime(new Date());
        }
        int[] ans= sybaseOrderService.insertOrders(orders);
        for (int i:ans){
            System.out.println(i);
        }
        OrderPojo[] orderPojos = cloudOrderService.updateOrder(orders);
        for (OrderPojo orderPojo:orderPojos){
            System.out.println(orderPojo);
        }
    }

}
