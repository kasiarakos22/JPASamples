package com.kasiarakos.application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kasiarakos.daos.EmployeeDao;
import com.kasiarakos.domain.Employee;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePersistence");
        EntityManager entityManager = emf.createEntityManager();
        EmployeeDao employeeDao = new EmployeeDao(entityManager);

        System.out.println("********** Creating Employees **********");
        entityManager.getTransaction().begin();
        System.out.println(employeeDao.createEmployee( "Dimitris Kasiaras", 50000, "6983203139"));
        System.out.println(employeeDao.createEmployee( "Sofia Karka", 50000, "6983203139"));
        System.out.println(employeeDao.createEmployee( "Nefeli Kasiaras", 50000, "6983203139"));
        entityManager.getTransaction().commit();

        System.out.println();

        System.out.println("********** Finding Employee by ID **********");
        var employeeFound = employeeDao.findById(1L);
        System.out.println("Employee Found " + employeeFound);
        System.out.println();

        System.out.println("********** Printing all Employees **********");
        List<Employee> allEmployees = employeeDao.findAll();
        allEmployees.forEach(System.out::println);
        System.out.println();

        System.out.println("********** Updating Employee **********");
        entityManager.getTransaction().begin();
        employeeDao.raiseEmployeeSalary(1, 1000);
        entityManager.getTransaction().commit();
        System.out.println("Updated " + employeeDao.findById(1));
        System.out.println();

        entityManager.getTransaction().begin();
        employeeDao.removeEmployee(1);
        entityManager.getTransaction().commit();
        System.out.println("Removed Employee 1");

        entityManager.close();
        emf.close();
    }
}
