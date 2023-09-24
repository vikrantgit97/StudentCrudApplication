package com.crudapp.controller;

import com.crudapp.entity.Course;
import com.crudapp.service.ICourseService;
import com.crudapp.utils.ViewExcel;
import com.crudapp.utils.ViewPDF;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author Vikrant on 19-09-2023
 * @Project StudentRegistrationApplication
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    public final ICourseService courseService;

    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/register")
    public String displayRegister(Model model) {
        model.addAttribute("course", new Course());
        return "CourseRegister";
    }

    @PostMapping("/save")
    public String saveForm(@ModelAttribute Course course, Model model) {
        Long id = courseService.saveCourse(course);
        String message = "Record ( " + id + " ) is created";
        model.addAttribute("message", message);
        return "CourseRegister";
    }

    @GetMapping("/all")
    public String viewAll(Model model, @RequestParam(value = "message", required = false) String message) {

        model.addAttribute("list", courseService.getCoursesList());
        model.addAttribute("message", message);
        return "CourseData";
    }

    @GetMapping("/delete")
    public String deleteData(@RequestParam Long id, RedirectAttributes attributes) {
        try {
            courseService.removeCourse(id);
            attributes.addAttribute("message", "Record (" + id + ") is removed");
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
        }

        return "redirect:all";
    }

    @GetMapping("/edit")
    public String showEditPage(@RequestParam Long id, Model model, RedirectAttributes attr) {
        try {
            Course course = courseService.getOneCourse(id);
            model.addAttribute("course", course);
            return "CourseEdit";
        } catch (Exception e) {
            e.printStackTrace();
            attr.addAttribute("message", e.getMessage());
            return "redirect:all";
        }

    }

    @PostMapping("/update")
    public String updateData(@ModelAttribute Course course, RedirectAttributes attributes) {
        courseService.updateCourse(course);
        attributes.addAttribute("message", "Record (" + course.getId() + ") is updated");
        return "redirect:all";
    }

    @ResponseBody
    @GetMapping("/checkName")
    public String checkName(@RequestParam String name, @RequestParam Long id) {
        if (id == 0) {
            boolean nameUnique = courseService.isNameUnique(name);
            return (nameUnique) ? "" : "Name Already Exists";
        } else {
            boolean nameUniqueForEdit = courseService.isNameUniqueForEdit(name, id);
            return (nameUniqueForEdit) ? "" : "Name Already Exists";
        }

    }

    @ResponseBody
    @GetMapping("/checkCode")
    public String checkCode(@RequestParam String code, @RequestParam Long id) {
        if (id == 0) {
            boolean codeUnique = courseService.isCodeUnique(code);
            return (codeUnique) ? "" : "Code Already Exists";
        } else {
            boolean codeUniqueForEdit = courseService.isCodeUniqueForEdit(code, id);
            return (codeUniqueForEdit) ? "" : "Code Already Exists";
        }

    }

    @GetMapping("/excel")
    public ModelAndView viewExcel() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", courseService.getCoursesList());
        modelAndView.setView(new ViewExcel());
        return modelAndView;

    }

    @GetMapping("/pdf")
    public ModelAndView viewPdf() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new ViewPDF());
        List<Course> list = courseService.getCoursesList();
        modelAndView.addObject("list", list);
        return modelAndView;

    }
}
