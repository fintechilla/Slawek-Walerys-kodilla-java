package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EeeCoFacade {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CompanyDto companyDto;
    @Autowired
    EmployeeDto employeeDto;

    private static final Logger LOGGER = LoggerFactory.getLogger(EeeCoFacade.class);
    public void processSearchEee(String partName){
        //List<Employee> eees = employeeDao.retrieveEmployeesByName(partName);
        LOGGER.info("***In EeeCoFacade***");
        List<Employee> eees = employeeDto.findEmployee(partName);
        System.out.println("***Priniting Emplyee names including " + partName + "***");
        eees.stream()
                .forEach(e->System.out.println(e.getLastName().toString()));
        System.out.println("***End of Employee names***");
    }


    public void processSearchCo(CompanyDao companyDao, String partName){
        List<Company> cos = companyDao.retrieveCompaniesByCharacters(partName);
        System.out.println("***Priniting Company names including " + partName + "***");
        cos.stream()
                .forEach(c-> System.out.println(c.getName()));
        System.out.println("***End of Company names***");
    }
}
