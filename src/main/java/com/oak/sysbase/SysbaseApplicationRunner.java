package com.oak.sysbase;

import com.alibaba.fastjson2.JSONObject;
import com.oak.sysbase.Utils.sqlDate;
import com.oak.sysbase.model.Employee;
import com.oak.sysbase.model.Order;
import com.oak.sysbase.pojo.OrderPojo;
import com.oak.sysbase.pojo.testPojo;
import com.oak.sysbase.repository.EmployeeRepository;
import com.oak.sysbase.repository.OrderRepository;
import com.oak.sysbase.service.CloudOrderService;
import com.oak.sysbase.service.testnestService;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/******************************************************************
 * <p>
 *
 * </p>
 * @author oak
 * @version 1.0
 * @date 2024/2/18 10:07
 ******************************************************************/
@Component
public class SysbaseApplicationRunner implements ApplicationRunner {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private testnestService testnestService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CloudOrderService cloudOrderService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        List<Employee> allEmployees = employeeRepository.getAllEmployees();
//        System.out.println(JSONObject.toJSONString(allEmployees));
        System.out.println("---------------------");
        testPojo testPojo = new testPojo();
        testPojo.setUsername("kkk");
        testPojo.setPassword("kkk");
        JSONObject object = testnestService.getEngineMesasge(testPojo);
        System.out.println(object);
        System.out.println("########################  start  ########################");
//        sqlDate sqlDate = new sqlDate();
//        Date date = sqlDate.getDatetimeNow();
//        System.out.println("final: "+date);

//        OrderPojo[] orderPojos = cloudOrderService.getunAuditOrder();
//        for (OrderPojo i:orderPojos){
//            System.out.println(i);
//        }


//        Order order = new Order();
//        order.setOrderid(333);
//        order.setOrdernumber("ORDER3");
//        order.setOrgid(333);
//        order.setStateid(3);
//        order.setPatient_uid(333);
//        order.setDoctor_uid(333);
//        order.setUpdatetime(date);
//        boolean b = orderRepository.insertOneOrder(order);
//        System.out.println(b);

//        Employee employee = new Employee();
//        BigDecimal bigDecimal = new BigDecimal(50000);
//        employee.setId(4);
//        employee.setFirstName("IC");
//        employee.setLastName("RI");
//        employee.setSalary(bigDecimal);
//        boolean a = employeeRepository.insertOne(employee);
//        System.out.println(a);
    }
}
