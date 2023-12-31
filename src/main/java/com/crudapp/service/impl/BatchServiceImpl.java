package com.crudapp.service.impl;

import com.crudapp.entity.BatchesRequest;
import com.crudapp.repo.BatchRequestRepository;
import com.crudapp.service.IBatchService;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.crudapp.constants.BatchStatus.ACCEPTED;

/**
 * @author Vikrant on 18-09-2023
 * @Project StudentRegistrationApplication
 */

@Service
public class BatchServiceImpl implements IBatchService {

    private final BatchRequestRepository batchRequestRepository;

    public BatchServiceImpl(BatchRequestRepository batchRequestRepository) {
        this.batchRequestRepository = batchRequestRepository;
    }

    @Override
    public Long saveBatchesRequest(BatchesRequest batchesRequest) {
        return batchRequestRepository.save(batchesRequest).getId();
    }

    @Override
    public BatchesRequest getOneBatchRequest(Long id) {
        return batchRequestRepository.findById(id).get();
    }

    @Override
    public List<BatchesRequest> getAllBatchesRequests() {
        return batchRequestRepository.findAll();
    }

    @Override
    public void updateBatchesRequestStatus(Long id, String status) {
        BatchesRequest batchesRequest = batchRequestRepository.findById(id).get();
        Long batch_id = batchRequestRepository.save(batchesRequest).getId();
    }

    @Override
    public List<BatchesRequest> viewBatchesByStudentMail(String studentMail) {
        return batchRequestRepository.getAllStudentSlots(studentMail);
    }

    @Override
    public List<BatchesRequest> viewBatchesByTeacherMail(String teacherMail) {
        return batchRequestRepository.getAllTeacherSlots(teacherMail, ACCEPTED.name());
    }
}
