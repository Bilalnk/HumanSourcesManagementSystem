package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.concretes.JobAdvertisementManager;
import com.kodlama.hrms.core.utilities.Filters.JobAdvertisementFilter;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.JobAdvertisement;
import com.kodlama.hrms.entities.dtos.JobAdvertisementDto;
import com.kodlama.hrms.entities.dtos.JobAdvertisementWithCountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobadvertisement")
@CrossOrigin
public class JobAdvertisementController {

    private JobAdvertisementManager jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementManager jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public DataResult<JobAdvertisement> add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping(value = "/getactives")
    public DataResult<List<JobAdvertisement>> findByActiveTrue(){
        return this.jobAdvertisementService.findByActiveTrue();
    }

    @GetMapping(value = "/getactivesasc")
    public DataResult<List<JobAdvertisement>> findByActiveTrueOrderByPublishedDateDesc(){
        return this.jobAdvertisementService.findByActiveTrueOrderByPublishedDateDesc();
    }

    @GetMapping(value = "/getactiveandemployer")
    public DataResult<List<JobAdvertisement>> findByActiveTrueAndEmployerId(@RequestParam int employerId){
        return this.jobAdvertisementService.findByActiveTrueAndEmployerId(employerId);
    }

    @GetMapping("/updateAdvertisementActive")
    public Result updateAdvertisementActive(@RequestParam int id, @RequestParam boolean active){
        return this.jobAdvertisementService.updateAdvertisementActive(id, active);
    }
    @GetMapping("/getjobadvertisementdetails")
        public DataResult<List<JobAdvertisementDto>> getJobAdveritsementDetails() {
            return this.jobAdvertisementService.getJobAdveritsementDetails();
        }
    @GetMapping("/updateAdvertisementConfirm")
    public Result updateAdvertisementConfirm(@RequestParam int id, @RequestParam boolean confirm){
        return this.jobAdvertisementService.updateAdvertisementConfirmed(id, confirm);
    }


    @GetMapping("/getjobadvertisementbyid")
    public DataResult<Optional<JobAdvertisement>> getJobAdvertisementById(@RequestParam int id) {
        return this.jobAdvertisementService.getById(id);
    }

    @GetMapping("/getByConfirmedByEmployeesFalseOrderByPublishedDateDesc")
    public DataResult<List<JobAdvertisement>> getByConfirmedByEmployeesFalseOrderByPublishedDateDesc(){
        return this.jobAdvertisementService.findByConfirmedByEmployeesFalseOrderByPublishedDateDesc();
    }

    @PostMapping("/getfiltered")
    public DataResult<List<JobAdvertisement>> getFiltered(@RequestBody JobAdvertisementFilter jobAdvertisementFilter){
        return this.jobAdvertisementService.getFiltered(jobAdvertisementFilter);
    }

    @PostMapping("/get-filtered-and-paginated")
    public DataResult<JobAdvertisementWithCountDto> getFilteredAndPagination(@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "1") int pageNo, @RequestBody JobAdvertisementFilter jobAdvertisementFilter){
        return this.jobAdvertisementService.getTenByTen(jobAdvertisementFilter, pageSize, pageNo);
    }
}
