package com.crudapp.service.impl;

import com.crudapp.entity.Employee;
import com.crudapp.repo.EmployeeRepository;
import com.crudapp.service.IEmployeeService;

import java.util.List;

/**
 * @author Vikrant on 18-09-2023
 * @Project StudentRegistrationApplication
 */
public class EmployeeServiceImpl implements IEmployeeService
{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Integer saveEmployee(Employee employee) {
        return employeeRepository.save(employee).getId();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Integer id) {

    }

    @Override
    public Employee getOneEmployee(Integer id) {
        return employeeRepository.findById(id).orElseThrow(()->new IllegalArgumentException("employee not found : "+id));
    }

    @Override
    public void updateEmployee(Employee emp) {
        employeeRepository.save(emp);
    }
}
