package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studentDetails")
public class Student {

    @Id
    @Column(name = "studentId")
    private int id;

    @Column(name = "studentName")
    private String name;
    @Column(name = "studentCity")
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student [id = " + id + ", name = " + name + ", city = " + city + ']';
    }


}
