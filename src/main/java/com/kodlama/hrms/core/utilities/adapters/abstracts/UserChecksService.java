package com.kodlama.hrms.core.utilities.adapters.abstracts;

import com.kodlama.hrms.entities.abstracts.User;
import com.kodlama.hrms.entities.concretes.Candidates;
import org.springframework.stereotype.Component;

public interface UserChecksService {

    boolean CheckIfRealPerson(Candidates candidates);
}
