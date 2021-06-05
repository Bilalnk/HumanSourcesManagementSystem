package com.kodlama.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Candidates candidates;

    @JoinColumn(name = "position_id")
    @ManyToOne
    private JobPositions jobPositions;

    @Column(name = "workplace")
    @NotNull
    @NotBlank
    private String workPlace;

    @Column(name = "starting_date")
    @NotNull
    private Date startingDate;

    @Column(name = "departure_date")
    private Date departureDate;
}
