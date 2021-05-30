package com.kodlama.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "city")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
@EqualsAndHashCode(callSuper = false)
public class City {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city_no")
    private String cityNo;

    @Column(name = "city")
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<JobAdvertisement> jobAdvertisements;

}
