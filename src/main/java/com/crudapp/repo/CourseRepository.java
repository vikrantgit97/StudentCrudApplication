package com.crudapp.repo;

import com.crudapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Vikrant on 17-09-2023
 * @Project StudentRegistrationApplication
 */
public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query("select count(courseCode) from Course where courseCode=:code and id!=:id")
    public Integer codeCountForEdit(String code, Long id);

    @Query("select count(courseName) from Course where courseName=:name and id!=:id")
    public Integer nameCountForEdit(String name, Long id);

    @Query("SELECT id,courseName FROM Course")
    List<Object[]> getCourseIdAndName();
}
