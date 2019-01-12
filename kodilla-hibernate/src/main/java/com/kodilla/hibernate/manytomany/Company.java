package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQueries({
    @NamedNativeQuery(name="Company.searchCompaniesByName",
            query="select * from companies where company_name like :COMPANYNAME",
            resultClass = Company.class),

    @NamedNativeQuery(name = "Company.retrieveCompaniesByCharacters",
            query = "Select * from companies where substr(company_name, 1, 3) like :PARTNAME",
            resultClass = Company.class)
})
@Entity
@Table(name="COMPANIES")
public class Company {
    private int id;
    private String name;
    private List<Employee>employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name="COMPANY_ID")
    public int getId() {
        return id;
    }
    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }
    @ManyToMany(cascade = CascadeType.ALL,  mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
