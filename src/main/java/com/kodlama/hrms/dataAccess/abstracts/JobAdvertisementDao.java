package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.JobAdvertisement;
import com.kodlama.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    List<JobAdvertisement> findByActiveTrue();

    List<JobAdvertisement> findByActiveTrueOrderByPublishedDateDesc();

    List<JobAdvertisement> findByActiveTrueAndConfirmedByEmployeesTrueAndEmployerId(int employerId);

    @Query("select new com.kodlama.hrms.entities.dtos.JobAdvertisementDto(j.id, e.companyName, p.position, j.numberOfOpenPosition, j.publishedDate, j.closingDate) " +
            "from JobAdvertisement j inner join j.employer e inner join j.jobPosition p where j.active = true and e.isActivated=true and j.confirmedByEmployees = true")
    List<JobAdvertisementDto> getJobAdvertisementByDetails();


    @Query("select new com.kodlama.hrms.entities.dtos.JobAdvertisementDto(j.id, e.companyName, p.position, j.numberOfOpenPosition, j.publishedDate, j.closingDate) " +
            "from JobAdvertisement j inner join j.employer e inner join j.jobPosition p where j.active = true and e.isActivated=true and j.confirmedByEmployees = true and j.id=:id")
    Optional<JobAdvertisement> getJobAdvertisementByActive(int id);


    List<JobAdvertisement> findByConfirmedByEmployeesFalseOrderByPublishedDateDesc();
}

