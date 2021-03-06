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
@Table(name = "links_candidate")
public class CandidateLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private Candidates candidates;

    @Column(name = "link")
    private String link;

    @JoinColumn(name = "link_type_id")
    @ManyToOne
    private LinkType linkType;
}
