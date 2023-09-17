package com.crudapp.repo;

import com.crudapp.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vikrant on 17-09-2023
 * @Project StudentRegistrationApplication
 */
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
