package com.crudapp.repo;

import com.crudapp.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Vikrant on 17-09-2023
 * @Project StudentRegistrationApplication
 */

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    @Query("SELECT teacher FROM Teacher teacher INNER JOIN teacher.course as cr WHERE cr.id=:courseId")
    List<Teacher> findTeacherByCourseId(Long courseId);

    @Query("SELECT id, firstName, lastName FROM Teacher")
    public List<Object[]> getTeacherIdAndNames();

}
