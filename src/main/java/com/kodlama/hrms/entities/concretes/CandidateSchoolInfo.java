package com.kodlama.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidate_school_info")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","schoolDepartments"})
public class CandidateSchoolInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Candidates candidates;

    @ManyToOne
    @JoinColumn(name = "school_department_id")
    private SchoolDepartment schoolDepartment;

    @Column(name = "date_of_start")
    @NotNull
    @NotBlank
    private Date dateOfStart;

    @Column(name = "date_of_finish")
    private Date dateOfFinish;


}
