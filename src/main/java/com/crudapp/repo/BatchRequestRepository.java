package com.crudapp.repo;

import com.crudapp.entity.BatchesRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Vikrant on 17-09-2023
 * @Project StudentRegistrationApplication
 */
public interface BatchRequestRepository extends JpaRepository<BatchesRequest,Long> {

    @Modifying
    @Query("UPDATE BatchesRequest SET status=:status WHERE  id=:id")
    void updateSlotRequestStatus(Long id, String status);

    @Query("SELECT br FROM BatchesRequest br INNER JOIN  br.student as student WHERE student.email=:studentMail")
    List<BatchesRequest> getAllStudentSlots(String studentMail);

    @Query("SELECT br FROM BatchesRequest br INNER JOIN br.institute as appointment INNER JOIN appointment.teacher as teacher WHERE teacher.email = :studentMail AND br.status=:status")
    List<BatchesRequest> getAllTeacherSlots(String studentMail,String status);

}
