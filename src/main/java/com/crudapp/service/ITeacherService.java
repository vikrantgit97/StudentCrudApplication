package com.crudapp.service;
import com.crudapp.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @author Vikrant on 18-09-2023
 * @Project StudentRegistrationApplication
 */

public interface ITeacherService {
    public Long saveTeacher(Teacher teacher);

    public List<Teacher> getAllTeachers();

    public void removeTeacher(Long id);

    public Teacher getOneTeacher(Long id);

    public void updateTeacher(Teacher teacher);

    public Map<Long, String> getTeacherIdAndNames();

    List<Teacher> findTeacherByCourseId(Long courseId);
}

