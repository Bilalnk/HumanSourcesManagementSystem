package com.kodlama.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidate_favorite_advertisements")
public class CandidateFavoriteAdvertisements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name= "candidate_id")
    private Candidates candidates;

    @ManyToOne
    @JoinColumn(name = "job_advertisement_id")
    private JobAdvertisement jobAdvertisement;



}
