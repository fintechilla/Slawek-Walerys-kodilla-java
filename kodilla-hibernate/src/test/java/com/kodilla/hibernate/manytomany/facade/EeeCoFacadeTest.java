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
    EeeCoFacade eeeCoFacade;

    @Test
    public void processSearchEeePartNameTest() {
        //Given
        eeeCoFacade.processSearchEeeByPartLastName("iller");
        eeeCoFacade.processSearchEeeByLastName("Miller");
    }

    @Test
    public void processSearchCompanyByPartName() {
        //Given
        eeeCoFacade.processSearchCompanyByName("Data");
        eeeCoFacade.processSearchCompanyByPartName("Da");
        eeeCoFacade.processSearchCompanyContaining("Dat");
    }
}