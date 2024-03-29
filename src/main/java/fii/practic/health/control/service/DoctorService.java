package fii.practic.health.control.service;

import fii.practic.health.boundry.dto.DoctorDTO;
import fii.practic.health.entity.model.Doctor;

import java.util.List;

public interface DoctorService {

    List<Doctor> getAll();

    Doctor getById(Long id);

    Doctor save(Doctor doctor);

    List<Doctor> findDoctorsByPatientsFirstName(String firstName);

    Doctor update(Doctor doctor);

    void deleteDoctor(Long id);

}
