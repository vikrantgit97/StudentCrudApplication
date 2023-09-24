package com.crudapp.controller;

import com.crudapp.entity.Employee;
import com.crudapp.service.IEmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author Vikrant on 19-09-2023
 * @Project StudentRegistrationApplication
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    public final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/register")
    public String showRegister() {
        return "EmployeeRegister";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee, Model model) {
        Integer id = employeeService.saveEmployee(employee);
        String message = " Employee '" + id + "' created";
        model.addAttribute("message", message);
        return "EmployeeData";
    }

    @GetMapping("/all")
    public String viewAllEmployee(Model model, RedirectAttributes redirectAttributes) {
        List<Employee> list = employeeService.getAllEmployees();
        model.addAttribute("list",list);
        redirectAttributes.getAttribute("message");
        return "EmployeeData";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam Integer id, Model model) {
        employeeService.deleteEmployee(id);
        model.addAttribute("msg", "Employee " + id + " deleted...");
        return "redirect:all";
    }

    @GetMapping("/edit")
    public String showEmployeeEdit(@RequestParam Integer id, Model model) {
        Employee employee = employeeService.getOneEmployee(id);
        model.addAttribute("employee", employee);
        return "EmployeeEdit";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee, RedirectAttributes attr) {
        employeeService.updateEmployee(employee);
        String message = "Employee Updated";
        attr.addAttribute("message", message);
        return "redirect:all";
    }
}