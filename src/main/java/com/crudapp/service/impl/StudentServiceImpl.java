package com.crudapp.service.impl;

import com.crudapp.entity.Student;
import com.crudapp.exception.StudentNotFoundException;
import com.crudapp.repo.StudentRepository;
import com.crudapp.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	public Long saveStudent(Student student) {
		return repo.save(student).getId();
	}

	@Override
	public List<Student> getAllStudents() {
		return (List<Student>) repo.findAll();
	}

	@Override
	public void removeStudent(Long id) {
		repo.delete(getOneStudent(id));
	}

	@Override
	public Student getOneStudent(Long id) {
		return repo.findById(id).orElseThrow(() -> new StudentNotFoundException(id + "Not exist"));
	}

	@Override
	public void updateStudent(Student student) {
		if (repo.existsById(student.getId()))
			repo.save(student);

		else
			throw new StudentNotFoundException(student.getId() + "Not Exist");

	}

	@Override
	public Student getOneByEmail(String email) {
		return repo.findByEmail(email).orElseThrow(()->new IllegalArgumentException(" Student Not Found : "+email));
	}

}
