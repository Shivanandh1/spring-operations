package com.pm.patient_service.controller;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.Builder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
@Tag(name="Patient Management", description="APIs for managing patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    @Operation(summary="Get all patients", description="Retrieve a list of all patients in the system")
    public ResponseEntity<List<PatientResponseDto>> getPatients() {
        List<PatientResponseDto> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    @Operation(summary = "create a new patient", description = "Create a new patient with the provided details")
    public ResponseEntity<PatientResponseDto> createPatient(@Valid @RequestBody PatientRequestDto patientRequestDto) {
        PatientResponseDto createdPatient = patientService.createPatient(patientRequestDto);
        return ResponseEntity.ok().body(createdPatient);
    }

    @PutMapping("/{id}")
    @Operation(summary = "update an existing patient", description = "Update the details of an existing patient by their ID")
    public ResponseEntity<PatientResponseDto> updatePatient(@PathVariable UUID id,@Validated(Default.class) @RequestBody PatientRequestDto patientRequestDto){
        PatientResponseDto updatedPatient=patientService.updatePatient(id,patientRequestDto);
        return ResponseEntity.ok().body(updatedPatient);
    }
}
