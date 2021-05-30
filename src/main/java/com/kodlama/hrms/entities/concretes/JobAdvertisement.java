package com.kodlama.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisement")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "min_salary")
    private Double minSalary;

    @Column(name = "max_salary")
    private Double maxSalary;

    @Column(name = "number_of_open_position")
    private int numberOfOpenPosition;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "published_date")
    private Date publishedDate;

    @Column(name ="closing_date")
    private Date closingDate;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employers employer;

    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPositions jobPosition;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
