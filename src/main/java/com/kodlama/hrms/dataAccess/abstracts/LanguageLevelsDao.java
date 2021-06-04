package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.LanguageLevels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageLevelsDao extends JpaRepository<LanguageLevels, Integer> {

}
