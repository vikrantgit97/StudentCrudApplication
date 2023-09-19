package com.crudapp.service.impl;

import com.crudapp.entity.Institute;
import com.crudapp.repo.InstituteRepository;
import com.crudapp.service.IInstituteService;
import org.springframework.core.SpringVersion;

import java.util.List;

/**
 * @author Vikrant on 18-09-2023
 * @Project StudentRegistrationApplication
 */
public class InstituteServiceImpl implements IInstituteService {

    private final InstituteRepository instituteRepository;

    public InstituteServiceImpl(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }

    @Override
    public Long saveInstitute(Institute institute) {
        return instituteRepository.save(institute).getId();
    }

    @Override
    public void updateInstitute(Institute institute) {
        instituteRepository.save(institute);
    }

    @Override
    public void deleteInstitute(Long id) {
        instituteRepository.deleteById(id);
    }

    @Override
    public Institute getOneInstitute(Long id) {
        return instituteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Institute Not Found : " + id));
    }

    @Override
    public List<Institute> getAllInstitutes() {
        return instituteRepository.findAll();
    }

    @Override
    public List<Object[]> getInstitutesByTeacher(Long id) {
        return instituteRepository.getInstituteByTeacherId(id);
    }

    @Override
    public List<Object[]> getInstitutesByTeacherEmail(String userName) {
        return instituteRepository.getInstitutesByTeacherEmail(userName);
    }

    @Override
    public void updateSlotCountForInstitute(Long id, int count) {
        instituteRepository.updateBatchCountForInstitute(id, count);
    }
}
