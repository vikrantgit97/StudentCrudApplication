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
    BatchesRequest getOneBatchRequest(Long id);

    //ADMIN can view all batches
    List<BatchesRequest> getAllBatchesRequests();
    //ADMIN/student can update status
    void updateBatchesRequestStatus(Long id,String status);
    //STUDENT can see his batches
    List<BatchesRequest> viewBatchesByStudentMail(String studentMail);

    //TEACHER can see his batches
    List<BatchesRequest> viewBatchesByTeacherMail(String teacherMail);
}
