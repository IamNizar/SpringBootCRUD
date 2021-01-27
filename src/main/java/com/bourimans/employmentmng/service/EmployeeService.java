package com.bourimans.employmentmng.service;

import com.bourimans.employmentmng.model.Employee;
import com.bourimans.employmentmng.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getALLEmployee() {
        return repository.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        repository.save(employee);

    }

    @Override
    public Employee getEmployeeByID(Long id) {
       Employee e = repository.findById(id).orElse(null);
       return e;
    }


    @Override
    public void deleteEmployeeById(Long id) {
        repository.deleteById(id);
    }
}
