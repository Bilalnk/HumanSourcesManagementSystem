package com.kodlama.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_photo")
public class CandidatePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Candidates candidates;

    @Column(name = "preface")
    private String preface;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "uploaded_date")
    private LocalDateTime uploadedDate;

}
