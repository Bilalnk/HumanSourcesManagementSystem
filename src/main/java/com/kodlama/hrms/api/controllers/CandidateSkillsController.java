package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.CandidateSkillsService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.ErrorDataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.entities.concretes.CandidateSkills;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidateskills")
@CrossOrigin
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

    @ExceptionHandler(MethodArgumentNotValidException.class)//sistemde bu türden bir hata olursa yukrıdaki responseEntity'i bad request ile sarmala //hataları yakala
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors= new HashMap<>();

        for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
//        ErrorDataResult<Object> errors = new ErrorDataResult<>(validationErrors, "false");

        return new ErrorDataResult<>(validationErrors, "false");
    }

}
