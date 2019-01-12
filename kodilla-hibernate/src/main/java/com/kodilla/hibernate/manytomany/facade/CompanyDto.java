package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CompanyDto {
    private int id;
    private String name;
    private List<Employee>eees = new ArrayList<>();
    @Autowired
    CompanyDao companyDao;

    public void addCompany(Company company){
        companyDao.save(company);
    }
    public List<Company> findCompanyByName(String name){
        return companyDao.retrieveCompaniesByCharacters(name);
    }
    public List<Company> findCompanyByPartName(String name){
        return companyDao.searchCompaniesByName("%" + name + "%");
    }
    public List<Company> findCompanyByNameContaining(String name){
        return companyDao.findAllByNameContaining(name);
    }
}
