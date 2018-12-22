package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyEmployeeDaoTestSuite {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CompanyDao companyDao;


    public List<Integer> initializeDao(){
        List<Integer> ids = new ArrayList<>();
        Employee  employee1 = new Employee("John", "Smithson");
        Employee  employee2 = new Employee("Stephanie", "Clarks");
        Employee employee3 = new Employee("Linda", "Kovalson");

        Company  company1 = new Company("Software");
        Company company2 =  new Company("Data");
        Company company3 = new Company("Grey");

        company1.getEmployees().add(employee1);
        company1.getEmployees().add(employee2);
        company3.getEmployees().add(employee3);
        company3.getEmployees().add(employee1);
        company3.getEmployees().add(employee3);

        employee1.getCompanies().add(company1);
        employee1.getCompanies().add(company3);
        employee2.getCompanies().add(company2);
        employee3.getCompanies().add(company2);
        employee3.getCompanies().add(company3);

        companyDao.save(company1);
        ids.add(company1.getId());
        companyDao.save(company2);
        ids.add(company2.getId());
        companyDao.save(company3);
        ids.add(company3.getId());

        return ids;
    }
    public void cleanUpDao(List<Integer> ids){
        for (Integer id : ids){
            try {
                companyDao.delete(id);
            }catch (Exception e){

            }
        }
    }
    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarkson = new Employee("Stephanie", "Clarkson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters =  new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarkson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarkson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMastersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMastersId);
        Assert.assertNotEquals(0 , greyMatterId);

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMastersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }
    @Test
    public void testRetrieveEmployeesByName(){
        //Given
        String lastName = "Moller";
        long sizeBefore = employeeDao.count();
        Employee employee1 = new Employee("John", lastName);
        Employee employee2 = new Employee("Barbara", lastName);
        Employee employee3 = new Employee("Anna" , lastName);
        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);
        // When
        List<Employee> eees = employeeDao.retrieveEmployeesByName(lastName);
        System.out.println("No of names for " + lastName + " is " + eees.size());
        long sizeAftter = employeeDao.count();
        //Then
        Assert.assertEquals(3, eees.size());
        Assert.assertEquals(sizeBefore + 3, sizeAftter);
        //CleanUp
        employeeDao.delete(employee1);
        employeeDao.delete(employee2);
        employeeDao.delete(employee3);

    }
    @Test
    public void testRetrieveCompaniesByCharacters(){
        //Given
        List<Integer> ids = initializeDao();
        String partName = "Dat";
        //When
        List<Company> cos = companyDao.retrieveCompaniesByCharacters(partName);
        //Then
        Assert.assertEquals(8, cos.size());
        //CleanUp
        cleanUpDao(ids);
    }
}
