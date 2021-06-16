package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.JobAdvertisement;
import com.kodlama.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    List<JobAdvertisement> findByActiveTrue();

    List<JobAdvertisement> findByActiveTrueOrderByPublishedDateDesc();

    List<JobAdvertisement> findByActiveTrueAndEmployerId(int employerId);

    @Query("select new com.kodlama.hrms.entities.dtos.JobAdvertisementDto(j.id, e.companyName, p.position, j.numberOfOpenPosition, j.publishedDate, j.closingDate) from JobAdvertisement j inner join j.employer e inner join j.jobPosition p where j.active = true and e.isActivated=true ")
    List<JobAdvertisementDto> getJobAdvertisementByDetails();

}
