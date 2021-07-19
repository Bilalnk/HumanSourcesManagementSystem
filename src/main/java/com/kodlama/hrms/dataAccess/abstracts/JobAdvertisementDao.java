package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.core.utilities.Filters.JobAdvertisementFilter;
import com.kodlama.hrms.entities.concretes.JobAdvertisement;
import com.kodlama.hrms.entities.dtos.JobAdvertisementDto;
import com.kodlama.hrms.entities.dtos.JobAdvertisementWithCountDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

    List<JobAdvertisement> findByActiveTrue();

    List<JobAdvertisement> findByActiveTrueOrderByPublishedDateDesc();

    List<JobAdvertisement> findByActiveTrueAndConfirmedByEmployeesTrueAndEmployerId(int employerId);

    @Query("select new com.kodlama.hrms.entities.dtos.JobAdvertisementDto(j.id, e.companyName, p.position, j.numberOfOpenPosition, j.publishedDate, j.closingDate) " +
            "from JobAdvertisement j inner join j.employer e inner join j.jobPosition p where j.active = true and e.isActivated=true and j.confirmedByEmployees = true and j.closingDate >= current_date ")
    List<JobAdvertisementDto> getJobAdvertisementByDetails();


    @Query("select new com.kodlama.hrms.entities.dtos.JobAdvertisementDto(j.id, e.companyName, p.position, j.numberOfOpenPosition, j.publishedDate, j.closingDate) " +
            "from JobAdvertisement j inner join j.employer e inner join j.jobPosition p where j.active = true and e.isActivated=true and j.confirmedByEmployees = true and j.id=:id")
    Optional<JobAdvertisement> getJobAdvertisementByActive(int id);

    List<JobAdvertisement> findByConfirmedByEmployeesFalseOrderByPublishedDateDesc();

    List<JobAdvertisement> getByActiveTrueAndJobPositionIdOrderByPublishedDateDesc(int jobPositionId, Pageable pageable);




    @Query("Select new com.kodlama.hrms.entities.dtos.JobAdvertisementDto( j.id, e.companyName, p.position, j.numberOfOpenPosition, j.publishedDate, j.closingDate )  from JobAdvertisement j inner join j.employer e inner join j.jobPosition p " +
            "where( ((:#{#adFilter.isJobPositionIdEmptyOrNull()}) is true) Or j.jobPosition.id In (:#{#adFilter.jobPositionId})) " +
            "AND ( ((:#{#adFilter.isCityIdEmptyOrNull()}) is true) Or j.city.id In (:#{#adFilter.cityId}))" +
            "AND ( ((:#{#adFilter.isWayOfWorkIdEmptyOrNull()}) is true) Or j.wayOfWork.id In (:#{#adFilter.wayOfWorkId}))" +
            "AND (((:#{#adFilter.isWorkTypeIdEmptyOrNull()}) is true) Or j.workType.id In (:#{#adFilter.workTypeId}) )"+
            "AND (j.active =true)" +
            "AND (e.isActivated=true)" +
            "AND (j.confirmedByEmployees = true)" +
            "AND (j.closingDate >= current_date)" +
            "ORDER BY j.publishedDate DESC")
    List<JobAdvertisementDto> getByPaginatedAndFiltered(@Param("adFilter") JobAdvertisementFilter jobAdvertisementFilter, Pageable pageable);


    @Query("Select j from JobAdvertisement j " +
            "where( ((:#{#adFilter.isJobPositionIdEmptyOrNull()}) is true) Or j.jobPosition.id In (:#{#adFilter.jobPositionId})) " +
            "AND ( ((:#{#adFilter.isCityIdEmptyOrNull()}) is true) Or j.city.id In (:#{#adFilter.cityId}))" +
            "AND ( ((:#{#adFilter.isWayOfWorkIdEmptyOrNull()}) is true) Or j.wayOfWork.id In (:#{#adFilter.wayOfWorkId}))" +
            "AND (((:#{#adFilter.isWorkTypeIdEmptyOrNull()}) is true) Or j.workType.id In (:#{#adFilter.workTypeId}) )"+
            "AND (j.active =true)" +
            "AND (j.confirmedByEmployees = true)" +
            "ORDER BY j.publishedDate DESC")
    List<JobAdvertisement> getByFiltered(@Param("adFilter") JobAdvertisementFilter jobAdvertisementFilter);

}

