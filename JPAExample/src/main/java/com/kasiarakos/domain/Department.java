package com.kasiarakos.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
public class Department {


    @TableGenerator(name="Dep_Gen")
    @Id @GeneratedValue(generator="Dep_Gen")
    private long id;
    private String name;

    @OneToMany(mappedBy="department", targetEntity=Employee.class)
    private Collection<Employee> employees;

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
