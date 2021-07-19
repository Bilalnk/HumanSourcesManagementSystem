package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.Employers;

import java.util.List;
import java.util.Optional;

public interface EmployersService {

    DataResult<Employers> add(Employers employers);

    DataResult<List<Employers>> getAll();

    DataResult<Optional<Employers>> getById(int id);

    Result confirmEmployer(int id, boolean active);

    boolean isExist ( int employerId);

}
