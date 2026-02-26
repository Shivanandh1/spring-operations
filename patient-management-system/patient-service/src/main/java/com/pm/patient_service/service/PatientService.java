package com.pm.patient_service.service;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.exception.EmailAlreadyExistsException;
import com.pm.patient_service.exception.PatientNotFoundException;
import com.pm.patient_service.grpc.BillingServiceGrpcClient;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    private final BillingServiceGrpcClient billingServiceGrpcClient;

    public PatientService(PatientRepository patientRepository, BillingServiceGrpcClient billingServiceGrpcClient) {
        this.patientRepository = patientRepository;
        this.billingServiceGrpcClient = billingServiceGrpcClient;
    }

    public List<PatientResponseDto> getPatients() {

        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDto> patientResponseDtos = patients.stream()
                .map(PatientMapper::toDto).toList();

        return patientResponseDtos;
    }

    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto)  {

        if(patientRepository.existsByEmail(patientRequestDto.getEmail())){
            throw new EmailAlreadyExistsException("Email already exists: " + patientRequestDto.getEmail());
        }
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDto));

        billingServiceGrpcClient.createBillingAccount(newPatient.getId().toString(), newPatient.getName(), newPatient.getEmail());


        return PatientMapper.toDto(newPatient);
    }

    public PatientResponseDto updatePatient(UUID id, PatientRequestDto patientRequestDto){

           Patient existingPatient=patientRepository.findById(id).orElseThrow(() ->
                   new PatientNotFoundException("Patient not found with id: " + id));

        if(patientRepository.existsByEmail(patientRequestDto.getEmail())){
            throw new EmailAlreadyExistsException("Email already exists: " + patientRequestDto.getEmail());
        }
        existingPatient.setName(patientRequestDto.getName());
        existingPatient.setEmail(patientRequestDto.getEmail());
        existingPatient.setAddress(patientRequestDto.getAddress());
        existingPatient.setDateOfBirth(existingPatient.getDateOfBirth());
        existingPatient.setRegisteredDate(existingPatient.getRegisteredDate());

        Patient updatedPatient=patientRepository.save(existingPatient);

        return PatientMapper.toDto(updatedPatient);

    }
}