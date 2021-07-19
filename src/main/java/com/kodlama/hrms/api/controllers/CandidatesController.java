package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.CandidatesService;
import com.kodlama.hrms.core.utilities.result.*;
import com.kodlama.hrms.entities.concretes.Candidates;

import com.kodlama.hrms.entities.dtos.CVDto;
import com.kodlama.hrms.entities.dtos.CvPersonalInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
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
    public DataResult<Optional<Candidates>> getById(@RequestParam(value = "id") @Valid int id){
        return this.candidatesService.getById(id);
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Result add(@RequestBody @Valid Candidates candidates){
        return this.candidatesService.add(candidates);
    }

    @GetMapping("/getcv")
    public DataResult<CVDto> getCv(@Valid @RequestParam  int id){
        return this.candidatesService.getCvById(id);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CvPersonalInfoDto cvPersonalInfoDto){
        return this.candidatesService.update(cvPersonalInfoDto);
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
