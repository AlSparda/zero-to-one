package ru.zero_to_one.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@Table(name = "research_worker")
public class ResearchWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false)
    private UUID id;

    @CreationTimestamp
    @Column(name = "created_time", nullable = false, columnDefinition = "TIMESTAMP")
    private Instant createdTime;

    @UpdateTimestamp
    @Column(name = "updated_time", nullable = false, columnDefinition = "TIMESTAMP")
    private Instant updatedTime;

    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "password", nullable = false, length = Integer.MAX_VALUE)
    private String password;

    @Column(name = "first_name_rus", length = Integer.MAX_VALUE)
    private String firstNameRus;

    @Column(name = "second_name_rus", length = Integer.MAX_VALUE)
    private String secondNameRus;

    @Column(name = "last_name_rus", length = Integer.MAX_VALUE)
    private String lastNameRus;

    @Column(name = "first_name_eng", length = Integer.MAX_VALUE)
    private String firstNameEng;

    @Column(name = "second_name_eng", length = Integer.MAX_VALUE)
    private String secondNameEng;

    @Column(name = "last_name_eng", length = Integer.MAX_VALUE)
    private String lastNameEng;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "snils", length = 16)
    private String snils;

    @Column(name = "scientific_role", length = Integer.MAX_VALUE)
    private String scientificRole;

    @Column(name = "supervisor", length = Integer.MAX_VALUE)
    private String supervisor;

    @Column(name = "cours")
    private Integer cours;

    @Column(name = "class", length = 50)
    private String classField;

    @Column(name = "date_of_study_end")
    private LocalDate dateOfStudyEnd;

    @Column(name = "id_rinc", length = Integer.MAX_VALUE)
    private String idRinc;

    @Column(name = "id_orcid", length = Integer.MAX_VALUE)
    private String idOrcid;

    @Column(name = "id_scopus", length = Integer.MAX_VALUE)
    private String idScopus;

    @Column(name = "id_researcher", length = Integer.MAX_VALUE)
    private String idResearcher;

    @Column(name = "id_colab", length = Integer.MAX_VALUE)
    private String idColab;

}