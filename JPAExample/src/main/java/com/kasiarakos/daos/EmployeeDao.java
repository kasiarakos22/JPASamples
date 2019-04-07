package com.kasiarakos.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.kasiarakos.domain.Employee;

public class EmployeeDao {
    protected EntityManager entityManager;

    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Employee createEmployee(int id, String name, long salary) {
        Employee employee = new Employee(id);
        employee.setName(name);
        employee.setSalary(salary);
        entityManager.persist(employee);
        return employee;
    }

    public void removeEmployee(int id) {
        Employee employee = findById(id);
        if (employee != null) {
            entityManager.remove(employee);
        }
    }

    public Employee raiseEmployeeSalary(int id, long raise) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            employee.setSalary(employee.getSalary() + raise);
        }
        return employee;
    }

    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }
}
