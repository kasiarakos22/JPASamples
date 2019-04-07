package com.kasiarakos.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Access(AccessType.FIELD)
public class Employee {

    @Id
    private int id;
    private String name;
    private long salary;
    @javax.persistence.Basic
    @Transient
    private String phone;

    public Employee() {
    }

    public Employee(int id) {
        this.id = id;
    }

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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Access(AccessType.PROPERTY)
    @Column(name = "phone")
    public String getPhoneDB() {
        return phone.substring(phone.length() - 10);
    }

    public void setPhoneDB(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", salary=" + salary +
            ", phone='" + phone + '\'' +
            '}';
    }
}
