package com.crudapp.repo;

import com.crudapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vikrant on 17-09-2023
 * @Project StudentRegistrationApplication
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
