package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.City;

public interface CityService {

    DataResult<City> getAll();

}
