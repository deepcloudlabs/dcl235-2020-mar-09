package com.example.hr.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

public class Dept {
    private int deptId;
    @JsonManagedReference
    private List<Employee> employees;
    private String name;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employeeList) {
        this.employees = employeeList;
        for (Employee a : employeeList) {
            a.setDept(this);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", employees=" + employees +
                ", name='" + name + '\'' +
                '}';
    }
}