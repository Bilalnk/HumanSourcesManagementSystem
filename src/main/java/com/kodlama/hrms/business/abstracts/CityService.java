package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();

}
