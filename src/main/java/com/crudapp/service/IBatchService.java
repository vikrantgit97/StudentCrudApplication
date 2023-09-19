package com.crudapp.service;

import com.crudapp.entity.BatchesRequest;

import java.util.List;

/**
 * @author Vikrant on 18-09-2023
 * @Project StudentRegistrationApplication
 */
public interface IBatchService {
    //student can book batch
    Long saveBatchesRequest(BatchesRequest batchesRequest);
    //fetch one
    BatchesRequest getOneSlotRequest(Long id);

    //ADMIN can view all batches
    List<BatchesRequest> getAllBatchesRequests();
    //ADMIN/student can update status
    void updateBatchesRequestStatus(Long id,String status);
    //STUDENT can see his batches
    List<BatchesRequest> viewSlotsByStudentMail(String studentMail);

    //TEACHER can see his batches
    List<BatchesRequest> viewSlotsByTeacherMail(String teacherMail);
}
