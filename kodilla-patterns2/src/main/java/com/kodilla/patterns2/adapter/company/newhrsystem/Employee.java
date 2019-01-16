package com.kodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;

public class Employee {
    private String peselId;
    private String firstname;
    private String lastname;
    private BigDecimal baseSalary;

    public Employee(String peselId, String firstname, String lastname) {
        this.peselId = peselId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.baseSalary = baseSalary;
    }

    public String getPeselId() {
        return peselId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(BigDecimal baseSalary){
        this.baseSalary = baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return getPeselId() != null ? getPeselId().equals(employee.getPeselId()) : employee.getPeselId() == null;
    }

    @Override
    public int hashCode() {
        return getPeselId() != null ? getPeselId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "peselId='" + peselId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
