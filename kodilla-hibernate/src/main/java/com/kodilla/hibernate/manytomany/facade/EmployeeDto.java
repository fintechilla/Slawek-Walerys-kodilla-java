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

    public void addEmployee(Employee employee){
        employeeDao.save(employee);
    }

    public List<Employee> findEmployeeByPartLastName(String partName){
        return employeeDao.retrieveEmployeesByName("%" + partName + "%");
    }

    public List<Employee> findEmployeeByLastName(String name){
        return employeeDao.retrieveEmployeesByName(name);
    }

}
