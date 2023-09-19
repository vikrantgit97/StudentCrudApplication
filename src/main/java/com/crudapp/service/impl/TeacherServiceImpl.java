package com.crudapp.service.impl;

import com.crudapp.entity.Teacher;
import com.crudapp.repo.TeacherRepository;
import com.crudapp.service.ITeacherService;
import com.crudapp.utils.ListToMapConverter;

import java.util.List;
import java.util.Map;

/**
 * @author Vikrant on 18-09-2023
 * @Project StudentRegistrationApplication
 */
public class TeacherServiceImpl implements ITeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Long saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher).getId();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void removeTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher getOneTeacher(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Teacher Not found : " + id));
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public Map<Long, String> getTeacherIdAndNames() {
        List<Object[]> list = teacherRepository.getTeacherIdAndNames();
        return ListToMapConverter.convertToMapIndex(list);
    }

    @Override
    public List<Teacher> findTeacherByCourseId(Long courseId) {
        return teacherRepository.findTeacherByCourseId(courseId);
    }
}
