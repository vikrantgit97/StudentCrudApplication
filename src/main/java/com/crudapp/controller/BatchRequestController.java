package com.crudapp.controller;

import com.crudapp.constants.BatchStatus;
import com.crudapp.entity.BatchesRequest;
import com.crudapp.entity.Institute;
import com.crudapp.entity.Student;
import com.crudapp.entity.User;
import com.crudapp.service.IBatchService;
import com.crudapp.service.IInstituteService;
import com.crudapp.service.IStudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.List;

import static com.crudapp.constants.BatchStatus.*;

/**
 * @author Vikrant on 19-09-2023
 * @Project StudentRegistrationApplication
 */

@Controller
@RequestMapping("/batches")
public class BatchRequestController {

    private final IBatchService batchService;

    private final IInstituteService instituteService;

    private final IStudentService studentService;

    public BatchRequestController(IBatchService batchService, IInstituteService instituteService, IStudentService studentService) {
        this.batchService = batchService;
        this.instituteService = instituteService;
        this.studentService = studentService;
    }

    //student_id, institute_id
    @GetMapping("/book")
    public String bookBatchRequest(Long insId, HttpSession httpSession, Model model) {
        Institute institute = instituteService.getOneInstitute(insId);

        //for patient object
        User user = (User) httpSession.getAttribute("userOb");
        String email = user.getUserName();
        Student student = studentService.getOneByEmail(email);

        //create batch
        BatchesRequest batchesRequest = new BatchesRequest();
        batchesRequest.setInstitute(institute);
        batchesRequest.setStudent(student);
        batchesRequest.setStatus(PENDING.name());
        try {

            batchService.saveBatchesRequest(batchesRequest);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            String appDte = sdf.format(institute.getDate());

            String message = " Student " + (student.getFirstName() + " " + student.getLastName())
                    + ", Request for Teacher " + institute.getTeacher().getFirstName() + " " + institute.getTeacher().getLastName()
                    + ", On Date : " + appDte + ", submitted with status: " + batchesRequest.getStatus();

            model.addAttribute("message", message);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "BOOKING REQUEST ALREADY MADE FOR THIS INSTITUTE/DATE");
        }
        return "BatchRequestMessage";
    }

    @GetMapping("/all")
    public String viewAllRequest(Model model) {
        List<BatchesRequest> allBatchesRequests = batchService.getAllBatchesRequests();
        model.addAttribute("list", allBatchesRequests);
        return "BatchRequestData";
    }

    @GetMapping("/student")
    public String viewRequestStudent(Principal principal,
                                       Model model) {
        String name = principal.getName();
        List<BatchesRequest> batchesRequests = batchService.viewBatchesByStudentMail(name);
        model.addAttribute("list", batchesRequests);
        return "BatchRequestDataStudent";
    }

    @GetMapping("/teacher")
    public String viewRequestTeacher(Principal principal,
                                     Model model) {
        String name = principal.getName();
        List<BatchesRequest> batchesRequests = batchService.viewBatchesByTeacherMail(name);
        model.addAttribute("list", batchesRequests);
        return "BatchRequestDataTeacher";
    }

    @GetMapping("/accept")
    public String updateBatchAccept(
            @RequestParam Long id
    )
    {
        batchService.updateBatchesRequestStatus(id, ACCEPTED.name());
        BatchesRequest sr = batchService.getOneBatchRequest(id);
        if(sr.getStatus().equals(ACCEPTED.name())) {
            instituteService.updateBatchCountForInstitute(
                    sr.getInstitute().getId(), -1);
        }
        return "redirect:all";
    }

    @GetMapping("/reject")
    public String updateBatchReject(
            @RequestParam Long id
    )
    {
        batchService.updateBatchesRequestStatus(id, REJECTED.name());
        return "redirect:all";
    }

    @GetMapping("/cancel")
    public String cancelBatchReject(
            @RequestParam Long id
    )
    {
        BatchesRequest sr = batchService.getOneBatchRequest(id);
        if(sr.getStatus().equals(ACCEPTED.name())) {
            batchService.updateBatchesRequestStatus(id, CANCELLED.name());
            instituteService.updateBatchCountForInstitute(
                    sr.getInstitute().getId(), 1);
        }
        return "redirect:student";
    }

}
