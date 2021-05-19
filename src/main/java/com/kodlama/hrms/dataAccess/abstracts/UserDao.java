package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
