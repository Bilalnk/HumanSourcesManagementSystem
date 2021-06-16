package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.WayOfWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WayOfWorkDao  extends JpaRepository<WayOfWork ,Integer> {
}
