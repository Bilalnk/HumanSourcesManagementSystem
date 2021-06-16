package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.WayOfWork;

import java.util.List;

public interface WayOfWorkService {

    DataResult<List<WayOfWork>> getAll();
}
