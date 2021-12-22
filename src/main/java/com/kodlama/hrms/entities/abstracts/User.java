package com.kodlama.hrms.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED) // extend edilenlere burdaki alanları da gönderir ?
@Entity
@Table(name = "users")
public abstract class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @NotBlank
    @Min(6)
    @Column(name = "password")
    private String password;


}

