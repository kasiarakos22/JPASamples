package com.kasiarakos.domain;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

@Entity
@Access(AccessType.FIELD)
public class Employee {

    @Id
    @TableGenerator(name="Emp_Gen")
    @GeneratedValue(generator="Emp_Gen")
    private long id;
    private String name;
    private long salary;

    @ManyToOne
    @JoinColumn(name="DEPT_ID")
    private Department department;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "PARKING_ID")
    private ParkingSpace parkingSpace;

    @ManyToMany
    @JoinTable(name="EMP_PROJ",
        joinColumns=@JoinColumn(name="EMP_ID"),
        inverseJoinColumns=@JoinColumn(name="PROJ_ID"))
    private Collection<Project> projects;

    @Embedded  private Address address;

    @ElementCollection
    private Collection<String> phones;

    @ElementCollection
    private Set<String> nickNames;


    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Collection<String> getPhones() {
        return phones;
    }

    public void setPhones(Collection<String>  phones) {
        this.phones = phones;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(Set<String> nickNames) {
        this.nickNames = nickNames;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", salary=" + salary +
            ", department=" + department +
            ", parkingSpace=" + parkingSpace +
            ", projects=" + projects +
            ", phones=" + phones +
            '}';
    }
}
