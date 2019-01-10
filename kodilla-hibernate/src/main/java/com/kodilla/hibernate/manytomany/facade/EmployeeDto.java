package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeDto {
    private int id;
    private String firstName;
    private String lastName;
    private List<Company>cos = new ArrayList<>();
    @Autowired
    EmployeeDao employeeDao;
    //@Bean
    public void addEmployee(Employee employee){
        employeeDao.save(employee);
    }
    public List<Employee> findEmployee(String lastName){
        return employeeDao.retrieveEmployeesByName(lastName);
    }
    public List<Employee> findEmployeeByPartName(String partName){
        return employeeDao.retrieveEmployeesByName(partName);
    }

}
