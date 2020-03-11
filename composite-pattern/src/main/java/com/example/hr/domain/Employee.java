package com.example.hr.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Employee {
    private int empId;
    @JsonBackReference
    private Dept dept;
    private String name;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", deptId=" + dept.getDeptId() +
                ", name='" + name + '\'' +
                '}';
    }
}