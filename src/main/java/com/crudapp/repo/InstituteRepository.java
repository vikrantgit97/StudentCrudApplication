package com.crudapp.repo;

import com.crudapp.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vikrant on 17-09-2023
 * @Project StudentRegistrationApplication
 */
public interface InstituteRepository extends JpaRepository<Institute,Long> {
}
