package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.Employers;

import java.util.List;

public interface EmployersService {

    DataResult<Employers> add(Employers employers);

    DataResult<List<Employers>> getAll();

}
