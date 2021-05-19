package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.JobPositionService;
import com.kodlama.hrms.entities.concretes.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobpositions")
public class JobsPositionController {

    JobPositionService jobPositionService;

    @Autowired
    public JobsPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public List<JobPositions> getAll(){
        return this.jobPositionService.getAll();
    }

    @GetMapping("/get/{id}")
    public Optional<JobPositions> getJobPositionById(@PathVariable int id){

        return this.jobPositionService.getById(id);
    }

    @GetMapping("/get")
    public Optional<JobPositions> getJobPositionByIdQuery(@RequestParam(value = "id") int id){

        return this.jobPositionService.getById(id);
    }

    @GetMapping("/getByName")
    public List<JobPositions> getJobPositionByNameQuery(@RequestParam(value = "position") String position){
        return this.jobPositionService.getByName(position);
    }

    @PostMapping(value = "/add" ,consumes ="application/json", produces = "application/json")
    public JobPositions add(@RequestBody JobPositions jobPositions){

        return this.jobPositionService.saveJobPosition(jobPositions);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){

         this.jobPositionService.delete(id);
    }

    @GetMapping("/delet")
    public void deleteBId(@RequestParam(value = "id", defaultValue = "0") int id){
        System.out.println(id);
    }

    @PutMapping("/update")
    public JobPositions update(@RequestBody JobPositions newJobPositions, @RequestParam("id") int id){
        return this.jobPositionService.updateById(id, newJobPositions);
    }
}
