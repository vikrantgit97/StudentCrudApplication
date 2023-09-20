package com.crudapp.service.impl;

import com.crudapp.entity.Course;
import com.crudapp.repo.CourseRepository;
import com.crudapp.service.ICourseService;
import com.crudapp.utils.ListToMapConverter;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Vikrant on 18-09-2023
 * @Project StudentRegistrationApplication
 */

@Service
public class CourseServiceImpl implements ICourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Long saveCourse(Course course) {
        return courseRepository.save(course).getId();
    }

    @Override
    public Map<Long, String> getAllCourses() {
        List<Course> list = courseRepository.findAll();
        List<Course> sortedList = list.stream().sorted(Comparator.comparing(Course::getCourseCode)).
                collect(Collectors.toList());
        return sortedList.stream().collect(Collectors.toMap(Course::getId, Course::getCourseName));
    }

    @Override
    public void removeCourse(Long id) {
        getOneCourse(id);
        courseRepository.deleteById(id);
    }

    @Override
    public Course getOneCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Course Not Found : " + id));
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public boolean isCodeUnique(String courseCode) {
        return courseRepository.findAll().stream().filter(a->a.getCourseCode().equals(courseCode)).count()==0;
    }

    @Override
    public boolean isCodeUniqueForEdit(String courseCode, Long id) {
        return courseRepository.codeCountForEdit(courseCode,id)==0;
    }

    @Override
    public boolean isNameUnique(String name) {
        return courseRepository.findAll().stream().filter(a->a.getCourseName().equals(name)).count()==0;
    }

    @Override
    public boolean isNameUniqueForEdit(String courseCode, Long id) {
        return courseRepository.codeCountForEdit(courseCode,id)==0;
    }

    @Override
    public List<Course> getCoursesList() {
        List<Course> list = courseRepository.findAll();
         Collections.sort(list,Comparator.comparing(Course::getCourseName));
        return list;
    }

    @Override
    public Map<Long, String> getSpecIdAndName() {
        List<Object[]> list = courseRepository.getCourseIdAndName();
        return ListToMapConverter.convertListOfObjectArrayToMap(list);
    }
}
