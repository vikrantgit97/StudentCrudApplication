package com.crudapp.service;

import com.crudapp.entity.Employee;

import java.util.List;

/**
 * @author Vikrant on 18-09-2023
 * @Project StudentRegistrationApplication
 */
public interface IEmployeeService {

    Integer saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    void deleteEmployee(Integer id);

    Employee getOneEmployee(Integer id);

    void updateEmployee(Employee emp);
}
