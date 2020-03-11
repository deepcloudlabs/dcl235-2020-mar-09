package com.example.hr.domain;

import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExampleMain2 {

    public static void main(String[] args) throws IOException {
        Employee emp1 = new Employee();
        emp1.setEmpId(1);
        emp1.setName("Tina");

        Employee emp2 = new Employee();
        emp2.setEmpId(2);
        emp2.setName("Joe");

        Dept dept = new Dept();
        dept.setName("IT");
        dept.setDeptId(3);
        dept.setEmployees(Arrays.asList(emp1, emp2));

        System.out.println("-- before serializing dept --");
        System.out.println(dept);

        System.out.println("-- json string after serializing --");
        ObjectMapper om = new ObjectMapper();
        String s = om.writeValueAsString(dept);
        System.out.println(s);
        System.out.println("-- deserializing --");
        Dept dept1 = om.readValue(s, Dept.class);
        System.out.println(dept1);
    }
}