package com.kodlama.hrms.entities.concretes;

import com.kodlama.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "birthdate")
    private Date Bod;

    @OneToMany(mappedBy = "candidates")
    private List<CandidateSchoolInfo> candidateSchoolInfos;


}
