package com.oak.sysbase.model;

import java.math.BigDecimal;

/******************************************************************
 * <p>
 *
 * </p>
 * @author oak
 * @version 1.0
 * @date 2024/2/18 10:04
 ******************************************************************/
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

}
