package com.kodlama.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "activation_codes")
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
public class ActivationCodes {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "is_confirmed", columnDefinition = "boolean default false")
    private boolean isConfirmed;

    @Column(name = "confirm_date")
    private Date confirmDate;

    @Column(name = "user_id")
    private int userId;



}
