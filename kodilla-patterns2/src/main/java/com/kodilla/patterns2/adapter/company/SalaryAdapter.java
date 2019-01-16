package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.newhrsystem.Employee;
import com.kodilla.patterns2.adapter.company.oldhrsystem.SalaryCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalaryAdapter extends SalaryAdaptee implements SalaryCalculator {
    @Override
    public double totalSalary(String[][] workers, double[] salaries){
        List<Employee> employeeList = new ArrayList<>();
        for(int n = 0; n < salaries.length; n++){
            Employee employee = new Employee(
                    workers[n][0],
                    workers[n][1],
                    workers[n][2]);
            employee.setBaseSalary(new BigDecimal(salaries[n]));
            employeeList.add(employee);
        }
        return calculateSalaries(employeeList).doubleValue();
    }
}
