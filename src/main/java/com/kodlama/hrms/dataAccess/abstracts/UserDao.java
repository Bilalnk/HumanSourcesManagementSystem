package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao<T> extends JpaRepository<User, Integer> {
}
