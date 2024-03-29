package fii.practic.health.boundry.controller;

import fii.practic.health.boundry.dto.PatientDTO;
import fii.practic.health.entity.model.Patient;
import fii.practic.health.control.service.DoctorService;
import fii.practic.health.control.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/patients")
public class PatientController {

    private PatientService patientService;

    private DoctorService doctorService;

    private ModelMapper modelMapper;

    @Autowired
    public PatientController(PatientService patientService, DoctorService doctorService, ModelMapper modelMapper) {
        this.patientService = patientService;
        this.doctorService = doctorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<Patient> getAll(){
        return patientService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Patient getById(@PathVariable Long id){
        return patientService.getById(id);
    }

    @PostMapping
    public Patient save(@RequestBody PatientDTO patientDTO){
        return patientService.save(modelMapper.map(patientDTO, Patient.class));
    }

    @PutMapping
    @RequestMapping(value = "/edit", method={RequestMethod.PUT})
    public Patient update(@RequestBody Patient patient){
        Patient updatePatient = patientService.update(modelMapper.map(patient, Patient.class));
        return updatePatient;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

}
