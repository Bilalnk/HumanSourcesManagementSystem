package com.kodlama.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "job_positions")
public class JobPositions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "position")
    private String position;

    public JobPositions() {
    }

    public JobPositions(int id, String position) {
        this.id = id;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobPositions that = (JobPositions) o;
        return id == that.id && Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position);
    }
}
