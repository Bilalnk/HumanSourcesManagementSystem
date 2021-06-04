package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.Languages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguagesDao extends JpaRepository<Languages, Integer> {
}
