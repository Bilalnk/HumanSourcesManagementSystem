package com.kodlama.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "can")
public class Candidates {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "birthdate")
    private Date Bod;

    @OneToOne
    private User user;

    public Candidates() {
    }

    public Candidates(String firstName, String lastName, String identityNumber, Date bod) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        Bod = bod;
    }
}
