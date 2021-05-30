package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.CandidatesService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.entities.concretes.Candidates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

    CandidatesService  candidatesService;

    @Autowired
    public CandidatesController(CandidatesService candidatesService) {
        this.candidatesService = candidatesService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candidates>> getAll(){
        return this.candidatesService.getAll();
    }

    @GetMapping("/get")
    public DataResult<Optional<Candidates>> getById(@RequestParam(value = "id") int id){
        return this.candidatesService.getById(id);
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Result add(@RequestBody Candidates candidates){
        return this.candidatesService.add(candidates);
    }

}
