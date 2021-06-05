package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.CandidateSkillsService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.entities.concretes.CandidateSkills;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(name = "/api/candidateskills")
public class CandidateSkillsController {

    private CandidateSkillsService skillsService;

    @Autowired
    public CandidateSkillsController(CandidateSkillsService skillsService) {
        this.skillsService = skillsService;
    }

    @GetMapping("/getall")
    public DataResult<List<CandidateSkills>> getAll() {
        return this.skillsService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody CandidateSkills candidateSkills){
        this.skillsService.addSkill(candidateSkills);
        return new SuccessResult(Messages.SUCCESS);
    }

}
