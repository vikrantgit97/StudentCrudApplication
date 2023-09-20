package com.crudapp.service;

import java.util.List;

import com.crudapp.entity.Student;


public interface IStudentService {

	public Long saveStudent(Student student);
	public List<Student> getAllStudents();
	public void removeStudent(Long id);
	public Student getOneStudent(Long id);
	public void updateStudent(Student student);

	public Student getOneByEmail(String email);

}
