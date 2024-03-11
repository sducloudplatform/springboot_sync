package com.oak.sysbase.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class OrderPojo {
    int orderid;
    String ordernumber;
    int patient_uid;
    int relation_orgid;
    int doctor_uid;
    int relation_stateid;
    Date updatetime;
}
