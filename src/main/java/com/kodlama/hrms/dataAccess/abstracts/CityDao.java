package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
}
