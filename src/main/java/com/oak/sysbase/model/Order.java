package com.oak.sysbase.model;

import lombok.Data;

import java.util.Date;
@Data
public class Order {
    int orderid;
    String ordernumber;
    int patient_uid;
    int orgid;
    int doctor_uid;
    int stateid;
    Date updatetime;
//    java.sql.Date updatetime;
}
