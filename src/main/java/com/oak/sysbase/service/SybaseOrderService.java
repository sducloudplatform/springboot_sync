package com.oak.sysbase.service;

import com.oak.sysbase.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SybaseOrderService {
    public int[] insertOrders(List<Order> orders);
}
