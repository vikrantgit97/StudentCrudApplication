package com.crudapp.repo;

import com.crudapp.entity.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Vikrant on 17-09-2023
 * @Project StudentRegistrationApplication
 */
public interface InstituteRepository extends JpaRepository<Institute,Long> {

    @Query("SELECT ins.date,ins.noOfBatches,ins.fee,teacher.email,teacher.mobile,ins.id FROM Institute ins INNER JOIN ins.teacher as teacher WHERE teacher.id=:teacherId")
    List<Object[]> getInstituteByTeacherId(Long teacherId);

    @Query("SELECT ins.date, ins.noOfBatches, ins.fee, ins.details FROM Institute ins INNER JOIN ins.teacher as teacher WHERE teacher.email=:userName AND ins.noOfBatches>0")
    public List<Object[]> getInstitutesByTeacherEmail(String userName);

    @Modifying
    @Query("UPDATE Institute SET noOfBatches = noOfBatches + :count WHERE id=:id")
    void updateBatchCountForInstitute(Long id, int count);
}
