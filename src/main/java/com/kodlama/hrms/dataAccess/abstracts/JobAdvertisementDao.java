package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    List<JobAdvertisement> findByActiveTrue();

    List<JobAdvertisement> findByActiveTrueOrderByPublishedDateDesc();

    List<JobAdvertisement> findByActiveTrueAndEmployerId(int employerId);
}
