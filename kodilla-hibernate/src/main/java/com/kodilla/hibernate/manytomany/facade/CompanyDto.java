package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CompanyDto {
    private int id;
    private String name;
    private List<Employee>eees = new ArrayList<>();

    CompanyDao companyDao;

    public void addCompany(Company company){
        companyDao.save(company);
    }
    public List<Company> findCompany(String name){
        return companyDao.retrieveCompaniesByCharacters(name);
    }
    public List<Company> findCompanyByPartName(String name){
        return companyDao.findAllByNameContaining(name);
    }
}
