package com.kodlama.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlama.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "candidates")
public class Candidates extends User{

    @Column(name = "firstname")
    @NotBlank
    @NotNull
    private String firstName;

    @Column(name = "lastname")
    @NotBlank
    @NotNull
    private String lastName;

    @Column(name = "identity_number")
    @NotBlank
    @NotNull
    private String identityNumber;

    @Column(name = "birthdate")
    @NotNull
    private Date Bod;

    @OneToMany(mappedBy = "candidates")
    @JsonIgnore
    @NotNull
    private List<CandidateSchoolInfo> candidateSchoolInfos;

    @OneToMany(mappedBy = "candidates")
    @NotNull
    @JsonIgnore
    private List<CandidateLanguages> candidateLanguages;

    @OneToMany(mappedBy = "candidates")
    @NotNull
    @JsonIgnore
    private List<CandidateSkills> candidateSkills;

    @OneToMany(mappedBy = "candidates")
    @NotNull
    @JsonIgnore
    private List<CandidateLinks> candidateLinks;

    @OneToMany(mappedBy = "candidates")
    @NotNull
    @JsonIgnore
    private List<Experience> experiences;

    @JsonIgnore
    @OneToMany(mappedBy = "candidates")
    private List<CandidateFavoriteAdvertisements> candidateFavoriteAdvertisements;

}
