package com.bourimans.employmentmng.service;

import com.bourimans.employmentmng.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getALLEmployee();
    void addEmployee(Employee employee);
    Employee getEmployeeByID(Long id);
    void deleteEmployeeById(Long id);
}
