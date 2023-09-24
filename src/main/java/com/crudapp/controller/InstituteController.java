package com.crudapp.controller;

import com.crudapp.entity.Course;
import com.crudapp.entity.Institute;
import com.crudapp.entity.Teacher;
import com.crudapp.service.ICourseService;
import com.crudapp.service.IInstituteService;
import com.crudapp.service.ITeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * @author Vikrant on 19-09-2023
 * @Project StudentRegistrationApplication
 */

@Controller
@RequestMapping("/institute")
public class InstituteController {

    public final IInstituteService instituteService;

    public final ICourseService courseService;

    public final ITeacherService teacherService;

    public InstituteController(IInstituteService instituteService, ICourseService courseService, ITeacherService teacherService) {
        this.instituteService = instituteService;
        this.courseService = courseService;
        this.teacherService = teacherService;
    }

    public void commonUi(Model model){
        model.addAttribute("teacher",teacherService.getTeacherIdAndNames());
    }

    @GetMapping("/register")
    public String registerInstitute(Model model){
        model.addAttribute("institute",new Institute());
        commonUi(model);
        return "InstituteRegister";
    }

    @PostMapping("/save")
    public String createInstitute(@ModelAttribute Institute institute, RedirectAttributes redirectAttributes) {
        Long id = instituteService.saveInstitute(institute);
        if (id != null) {
            redirectAttributes.addAttribute("msg", "INSTITUTE SAVED SUCCESSFULLY...");
        } else {
            redirectAttributes.addAttribute("msg", "SOMETHING WENT WRONG!!!");
        }
        return "redirect:/index";
    }

    @GetMapping("/viewBatch")
    public String showBatches(@RequestParam Long id, Model model) {
        // fetch apps based on teacher id
        List<Object[]> list = instituteService.getInstitutesByTeacher(id);
        model.addAttribute("list", list);
        Teacher teacher = teacherService.getOneTeacher(id);
        model.addAttribute("message", "RESULTS SHOWING FOR : " + teacher.getFirstName() + " " + teacher.getLastName());
        return "InstituteBatches";
    }

    // .. view institute page..
    @GetMapping("/view")
    public String viewBatches(@RequestParam(required = false, defaultValue = "0") Long courseId, Model model) {
        // fetch data for Course DropDown
        Map<Long, String> courseMap = courseService.getCourseIdAndName();
        model.addAttribute("institute", courseMap);

        List<Teacher> teacherList = null;
        String message = null;
        if (courseId <= 0) { // if they did not select any course
            teacherList = teacherService.getAllTeachers();
            message = "Result : All Doctors";
        } else {
            teacherList = teacherService.findTeacherByCourseId(courseId);
            message = "Result : " + courseService.getOneCourse(courseId).getCourseName() + " Teachers";
        }
        model.addAttribute("docList", teacherList);

        model.addAttribute("message", message);

        return "InstituteSearch";
    }

    @GetMapping("/all")
    public String allInstitutes(@RequestParam(required = false) String message, Model model) {
        List<Institute> institutes = instituteService.getAllInstitutes();
        model.addAttribute("institutes", institutes);
        model.addAttribute("message", message);
        return "InstituteData";
    }

    @GetMapping("/delete")
    public String deleteInstitute(@RequestParam Long id, RedirectAttributes attributes) {
        try {
            instituteService.deleteInstitute(id);
            attributes.addAttribute("message", "Institute deleted with Id:" + id);
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
        }
        return "redirect:all";
    }

    @GetMapping("/edit")
    public String editInstitute(@RequestParam Long id, Model model, RedirectAttributes attributes) {
        String page = null;
        try {
            Institute institute = instituteService.getOneInstitute(id);
            model.addAttribute("institute", institute);
            commonUi(model);
            page = "InstituteEdit";
        } catch (Exception e) {
            e.printStackTrace();
            attributes.addAttribute("message", e.getMessage());
            page = "redirect:all";
        }
        return page;
    }

    @PostMapping("/update")
    public String updateInstitute(@ModelAttribute Institute institute, RedirectAttributes attributes) {
        instituteService.updateInstitute(institute);
        attributes.addAttribute("message", "Institute updated");
        return "redirect:all";
    }
}
