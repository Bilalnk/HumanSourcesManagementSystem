package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    boolean existsByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);
}
