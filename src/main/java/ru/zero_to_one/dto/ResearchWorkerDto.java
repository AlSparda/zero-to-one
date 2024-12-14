package ru.zero_to_one.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Value;

/**
 * DTO for {@link ru.zero_to_one.entity.ResearchWorker}
 */
@Value
public class ResearchWorkerDto {

    UUID id;
    Instant createdTime;
    Instant updatedTime;
    String email;
    String firstNameRus;
    String secondNameRus;
    String lastNameRus;
    String firstNameEng;
    String secondNameEng;
    String lastNameEng;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dateOfBirth;
    String snils;
    String scientificRole;
    String supervisor;
    Integer cours;
    String classField;
    LocalDate dateOfStudyEnd;
    String idRinc;
    String idOrcid;
    String idScopus;
    String idResearcher;
    String idColab;
}