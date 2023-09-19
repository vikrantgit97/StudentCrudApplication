package com.crudapp.service;

import com.crudapp.entity.Institute;

import java.util.List;

/**
 * @author Vikrant on 18-09-2023
 * @Project StudentRegistrationApplication
 */
public interface IInstituteService {

    Long saveInstitute(Institute institute);

    void updateInstitute(Institute institute);

    void deleteInstitute(Long id);

    Institute getOneInstitute(Long id);

    List<Institute> getAllInstitutes();

    List<Object[]> getInstitutesByTeacher(Long id);

    List<Object[]> getInstitutesByTeacherEmail(String userName);

    void updateSlotCountForInstitute(Long id, int count);
}
