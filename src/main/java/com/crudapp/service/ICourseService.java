package com.crudapp.service;

import com.crudapp.entity.Course;

import java.util.List;
import java.util.Map;

/**
 * @author Vikrant on 18-09-2023
 * @Project StudentRegistrationApplication
 */
public interface ICourseService {

    public Long saveCourse(Course course);

    public Map<Long, String> getAllCourses();

    public void removeCourse(Long id);

    public Course getOneCourse(Long id);

    public void updateCourse(Course course);

    public boolean isCodeUnique(String courseCode);

    public boolean isCodeUniqueForEdit(String courseCode, Long id);

    public boolean isNameUnique(String name);

    public boolean isNameUniqueForEdit(String courseCode, Long id);

    public List<Course> getCoursesList();

    Map<Long, String> getSpecIdAndName();
}
