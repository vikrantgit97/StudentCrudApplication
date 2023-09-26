package com.crudapp.controller;

import com.crudapp.entity.Teacher;
import com.crudapp.service.ICourseService;
import com.crudapp.service.ITeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Vikrant on 19-09-2023
 * @Project StudentRegistrationApplication
 */

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    private final ITeacherService teacherService;

    private final ICourseService courseService;

    public TeacherController(ITeacherService teacherService, ICourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

    //1. show register
    public String showRegister(@RequestParam(value = "message", required = false) String message, Model model) {
        model.addAttribute("message", message);
        model.addAttribute("courses", courseService.getAllCourses());
        return "TeacherRegister";
    }

    // 2. save on submit
    @PostMapping("/save")
    public String save(@ModelAttribute Teacher teacher, RedirectAttributes attributes) {
        Long id = teacherService.saveTeacher(teacher);
        if (id != null) {
            attributes.addAttribute("message", "Teacher (" + id + ") is created");
            new Thread(() -> {
                try {
                    //mailUtil.send(teacher.getEmail(), "Registration Success", "Teacher (" + id + ") is created");
                    System.out.println((teacher.getEmail() + " Registration Success" + "Teacher (" + id + ") is created"));
                } catch (Exception e) {    //MessagingException
                    e.printStackTrace();
                }
            }).start();
            logger.info("Teacher id: (" + id + ") is created & mail sent successfully");
        } else {
            attributes.addAttribute("message", "Teacher Registration Failed");
            logger.error("Teacher Registration Failed");
        }
        return "redirect:register";
    }

    // 3. display data
    @GetMapping("/all")
    public String display(@RequestParam(value = "message", required = false) String message, Model model) {

        model.addAttribute("teacher", teacherService.getAllTeachers());
        model.addAttribute("message", message);
        return "TeacherData";
    }

    // 4. delete by id
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes attributes) {
        teacherService.removeTeacher(id);
        attributes.addAttribute("message", "Teacher removed");
        return "redirect:all";
    }

    // 5. show edit
    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model, RedirectAttributes attributes) {
        Teacher teacher = teacherService.getOneTeacher(id);
        model.addAttribute("teacher", teacher);
        return "TeacherEdit";
    }

    // 6. do update
    @PostMapping("/update")
    public String doUpdate(@ModelAttribute Teacher teacher, RedirectAttributes attributes) {
        teacherService.updateTeacher(teacher);
        attributes.addAttribute("message", teacher.getId() + ", updated!");
        return "redirect:all";
    }

}
