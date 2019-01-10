package com.kodilla.hibernate.manytomany.facade;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EeeCoFacadeTest {
    @Autowired
    EmployeeDto employeeDto;
    //@Autowired
    CompanyDto companyDto;
    @Autowired
    EeeCoFacade eeeCoFacade;

    @Test
    public void processSearchEeeTest() {
        //Given
        eeeCoFacade.processSearchEee("Moller");

    }

//    @Test
//    public void processSearchCo() {
//    }
}