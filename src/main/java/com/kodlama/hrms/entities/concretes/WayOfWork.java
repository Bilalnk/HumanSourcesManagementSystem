package com.kodlama.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "way_of_work")
@AllArgsConstructor
@NoArgsConstructor
public class WayOfWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    @NotNull
    @NotBlank
    private String wayWorking;

    @JsonIgnore
    @OneToMany(mappedBy = "wayOfWork")
    private List<JobAdvertisement> jobAdvertisements;

}
