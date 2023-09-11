package com.crudapp.controller;

import com.crudapp.entity.Student;
import com.crudapp.exception.StudentNotFoundException;
import com.crudapp.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentService service;

	// 1. show Register page
	@GetMapping("/register")
	public String showReg(@RequestParam(value = "message", required = false) String message, Model model) {
		model.addAttribute("message", message);
		return "StudentRegister";
	}

	// 2. save on submit
	@PostMapping("/save")
	public String save(@ModelAttribute Student student, RedirectAttributes attributes) {
		Long id = service.saveStudent(student);
		attributes.addAttribute("message", "Student (" + id + ") is created");
		return "redirect:register";
	}

	// 3. display data
	@GetMapping("/all")
	public String display(@RequestParam(value = "message", required = false) String message, Model model) {
		List<Student> list = service.getAllStudents();
		model.addAttribute("list", list);
		model.addAttribute("message", message);
		return "StudentData";
	}

	// 4. delete by id
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id, RedirectAttributes attributes) {
		String message = null;
		try {
			service.removeStudent(id);
			message = "Student removed";
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		attributes.addAttribute("message", message);
		return "redirect:all";
	}

	// 5. show edit
	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model, RedirectAttributes attributes) {
		String page = null;
		try {
			Student student = service.getOneStudent(id);
			model.addAttribute("Student", student);
			page = "StudentEdit";
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			attributes.addAttribute("message", e.getMessage());
			page = "redirect:all";
		}
		return page;
	}

	// 6. do update
	@PostMapping("/update")
	public String doUpdate(@ModelAttribute Student student, RedirectAttributes attributes) {
		service.updateStudent(student);
		attributes.addAttribute("message", student.getId() + ", updated!");
		return "redirect:all";
	}
}