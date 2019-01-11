package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EeeCoFacade {
//    @Autowired
//    CompanyDao companyDao;
//    @Autowired
//    EmployeeDao employeeDao;
    @Autowired
    CompanyDto companyDto;
    @Autowired
    EmployeeDto employeeDto;

    private static final Logger LOGGER = LoggerFactory.getLogger(EeeCoFacade.class);

    public void processSearchEeeByPartLastName(String partName){

        List<Employee> employees = employeeDto.findEmployeeByPartLastName(partName);
        System.out.println("***Priniting Emplyee names including " + partName + "***");
        employees.stream()
                .forEach(e->System.out.println(e.getLastName()));
        System.out.println("***End of Employee names***");
    }
    public void processSearchEeeByLastName(String name){

        List<Employee> employees = employeeDto.findEmployeeByLastName(name);
        System.out.println("***Priniting Emplyees with name " + name + "***");
        employees.stream()
                .forEach(e->System.out.println(e.getLastName().toString()));
        System.out.println("***End of Employee names***");
    }
    public void processSearchCompanyByName(String name){
        List<Company> cos = companyDto.findCompanyByName(name);
        System.out.println("***Priniting Company names with name " + name + "***");
        cos.stream()
                .forEach(c-> System.out.println(c.getName()));
        System.out.println("***End of Company names***");
    }
    public void processSearchCompanyByPartName(String partName){
        List<Company> cos = companyDto.findCompanyByPartName(partName);
        System.out.println("***Priniting Company names including " + partName + "***");
        cos.stream()
                .forEach(c-> System.out.println(c.getName()));
        System.out.println("***End of Company names***");
    }
    public void processSearchCompanyContaining(String name){
        List<Company> cos = companyDto.findCompanyByPartName(name);
        System.out.println("***Priniting Company names containing " + name + "***");
        cos.stream()
                .forEach(c-> System.out.println(c.getName()));
        System.out.println("***End of Company names***");
    }


}
