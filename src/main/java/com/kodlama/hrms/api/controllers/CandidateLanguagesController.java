package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.CandidateLanguagesService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.entities.concretes.CandidateLanguages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidatelangs")
public class CandidateLanguagesController{

    private CandidateLanguagesService candidateLanguagesService;

    @Autowired
    public CandidateLanguagesController(CandidateLanguagesService candidateLanguagesService) {
        this.candidateLanguagesService = candidateLanguagesService;
    }


    @GetMapping("/getall")
    public DataResult<List<CandidateLanguages>> getAll(){
        return this.candidateLanguagesService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CandidateLanguages candidateLanguages){
        this.candidateLanguagesService.add(candidateLanguages);
        return new SuccessResult(Messages.SUCCESS);
    }
}
