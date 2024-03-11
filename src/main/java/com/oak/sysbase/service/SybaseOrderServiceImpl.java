package com.oak.sysbase.service;

import com.oak.sysbase.model.Order;
import com.oak.sysbase.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SybaseOrderServiceImpl implements SybaseOrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public int[] insertOrders(List<Order> orders){return orderRepository.insertOrders(orders);}

}
