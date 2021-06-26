package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.core.utilities.Filters.JobAdvertisementFilter;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.JobAdvertisement;
import com.kodlama.hrms.entities.dtos.JobAdvertisementDto;
import org.hibernate.sql.Select;
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
            "from JobAdvertisement j inner join j.employer e inner join j.jobPosition p where j.active = true and e.isActivated=true and j.confirmedByEmployees = true")
    List<JobAdvertisementDto> getJobAdvertisementByDetails();


    @Query("select new com.kodlama.hrms.entities.dtos.JobAdvertisementDto(j.id, e.companyName, p.position, j.numberOfOpenPosition, j.publishedDate, j.closingDate) " +
            "from JobAdvertisement j inner join j.employer e inner join j.jobPosition p where j.active = true and e.isActivated=true and j.confirmedByEmployees = true and j.id=:id")
    Optional<JobAdvertisement> getJobAdvertisementByActive(int id);


    List<JobAdvertisement> findByConfirmedByEmployeesFalseOrderByPublishedDateDesc();

    List<JobAdvertisement> getByActiveTrueAndJobPositionIdOrderByPublishedDateDesc(int jobPositionId, Pageable pageable);




    /*@Query("Select j from JobAdvertisement j where ((:#{#filter.jobPositionId}) IS NULL Or j.jobPosition.id In (:#{#filter.jobPositionId}))" +
            "AND  ((:#{#filter.cityId}) IS NULL Or j.city.id In (:#{#filter.cityId}))" +
            "AND  ((:#{#filter.wayOfWorkId}) IS NULL Or j.wayOfWork.id In (:#{#filter.wayOfWorkId}))" +
            "AND  ((:#{#filter.workTypeId}) IS NULL Or j.workType.id In (:#{#filter.workTypeId}))")
    Page<JobAdvertisement> getByPaginatedAndFiltered(@Param("filter") JobAdvertisementFilter jobAdvertisementFilter, Pageable pageable);
    */





 /*   @Query("Select j from JobAdvertisement j where ((:#{#filter.jobPositionId}) IS NULL Or j.jobPosition.id In (:jobAdvertisementFilter.jobPositionId))" +
            "AND  ((:#{#filter.cityId}) IS NULL Or j.city.id In (:#{#filter.cityId}))" +
            "AND  ((:#{#filter.wayOfWorkId}) IS NULL Or j.wayOfWork.id In (:#{#filter.wayOfWorkId}))" +
            "AND  ((:#{#filter.workTypeId}) IS NULL Or j.workType.id In (:#{#filter.workTypeId}))")
    Page<JobAdvertisement> getByPaginatedAndFiltered(JobAdvertisementFilter jobAdvertisementFilter, Pageable pageable);*/
}

