package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.ActivationCodes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivationCodesDao extends JpaRepository<ActivationCodes, Integer> {

    Optional<ActivationCodes> findByUserId(int id);

}
