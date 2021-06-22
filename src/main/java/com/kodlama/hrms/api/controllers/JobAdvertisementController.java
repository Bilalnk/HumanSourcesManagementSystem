package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.concretes.JobAdvertisementManager;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.JobAdvertisement;
import com.kodlama.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobadvertisement")
@CrossOrigin
public class JobAdvertisementController {

    private JobAdvertisementManager jobAdvertisementManager;

    @Autowired
    public JobAdvertisementController(JobAdvertisementManager jobAdvertisementManager) {
        this.jobAdvertisementManager = jobAdvertisementManager;
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public DataResult<JobAdvertisement> add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementManager.add(jobAdvertisement);
    }

    @GetMapping(value = "/getactives")
    public DataResult<List<JobAdvertisement>> findByActiveTrue(){
        return this.jobAdvertisementManager.findByActiveTrue();
    }

    @GetMapping(value = "/getactivesasc")
    public DataResult<List<JobAdvertisement>> findByActiveTrueOrderByPublishedDateDesc(){
        return this.jobAdvertisementManager.findByActiveTrueOrderByPublishedDateDesc();
    }

    @GetMapping(value = "/getactiveandemployer")
    public DataResult<List<JobAdvertisement>> findByActiveTrueAndEmployerId(@RequestParam int employerId){
        return this.jobAdvertisementManager.findByActiveTrueAndEmployerId(employerId);
    }

    @GetMapping("/updateAdvertisementActive")
    public Result updateAdvertisementActive(@RequestParam int id, @RequestParam boolean active){
        return this.jobAdvertisementManager.updateAdvertisementActive(id, active);
    }

    @GetMapping("/updateAdvertisementConfirm")
    public Result updateAdvertisementConfirm(@RequestParam int id, @RequestParam boolean confirm){
        return this.jobAdvertisementManager.updateAdvertisementConfirmed(id, confirm);
    }

    @GetMapping("/getjobadvertisementdetails")
    public DataResult<List<JobAdvertisementDto>> getJobAdveritsementDetails() {
        return this.jobAdvertisementManager.getJobAdveritsementDetails();
    }

    @GetMapping("/getjobadvertisementbyid")
    public DataResult<Optional<JobAdvertisement>> getJobAdveritsementById(@RequestParam int id) {
        return this.jobAdvertisementManager.getById(id);
    }

    @GetMapping("/getByConfirmedByEmployeesFalseOrderByPublishedDateDesc")
    public DataResult<List<JobAdvertisement>> getByConfirmedByEmployeesFalseOrderByPublishedDateDesc(){
        return this.jobAdvertisementManager.findByConfirmedByEmployeesFalseOrderByPublishedDateDesc();
    }
}
