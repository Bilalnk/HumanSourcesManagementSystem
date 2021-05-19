package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.CandidatesService;
import com.kodlama.hrms.entities.concretes.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {

    CandidatesService  candidatesService;

    @Autowired
    public CandidatesController(CandidatesService candidatesService) {
        this.candidatesService = candidatesService;
    }

    @GetMapping("/getall")
    public List<Candidates> getAll(){
        return this.candidatesService.getAll();
    }

}
