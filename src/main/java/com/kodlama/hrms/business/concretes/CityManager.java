package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.CityService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.dataAccess.abstracts.CityDao;
import com.kodlama.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<City> getAll() {
        return null;
    }
}
