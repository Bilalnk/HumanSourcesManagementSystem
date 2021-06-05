package com.kodlama.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages_candidate")
public class CandidateLanguages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    @NotBlank
    @NotNull
    private int candidateId;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Languages languages;

    @ManyToOne
    @JoinColumn(name = "language_level_id")
    private LanguageLevels languageLevels;
}
