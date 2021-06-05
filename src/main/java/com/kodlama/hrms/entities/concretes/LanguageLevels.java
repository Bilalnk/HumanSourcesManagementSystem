package com.kodlama.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "language_levels")
public class LanguageLevels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "language_level")
    @NotNull
    @NotBlank
    private String languageLevel;

    @OneToMany(mappedBy = "languageLevels")
    @JsonIgnore
    private List<CandidateLanguages> candidateLanguages;
}
