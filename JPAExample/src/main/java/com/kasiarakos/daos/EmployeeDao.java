package com.kasiarakos.daos;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.kasiarakos.domain.Employee;

public class EmployeeDao {
    private EntityManager entityManager;

    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Employee createEmployee(String name, long salary, String phone) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSalary(salary);
        employee.setPhones(Arrays.asList(phone));
        entityManager.persist(employee);
        return employee;
    }

    public void removeEmployee(long id) {
        Employee employee = findById(id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }

    public Employee raiseEmployeeSalary(long id, long raise) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            employee.setSalary(employee.getSalary() + raise);
        }
        return employee;
    }

    public Employee findById(long id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }
}
