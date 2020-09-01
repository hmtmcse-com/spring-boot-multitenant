package com.hmtmcse.multitenant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public Integer age;

    public Student() {}

    public Student(String name, Integer age) {
        this.age = age;
        this.name = name;
    }


}
