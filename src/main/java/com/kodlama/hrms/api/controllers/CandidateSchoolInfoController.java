package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.CandidateSchoolInfoService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.ErrorDataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.CandidateSchoolInfo;
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
@RequestMapping("/api/candidateschoolinfo")
public class CandidateSchoolInfoController {

    private CandidateSchoolInfoService candidateSchoolInfoService;

    @Autowired
    public CandidateSchoolInfoController(CandidateSchoolInfoService candidateSchoolInfoService) {
        this.candidateSchoolInfoService = candidateSchoolInfoService;
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody CandidateSchoolInfo candidateSchoolInfo) {
        return this.candidateSchoolInfoService.add(candidateSchoolInfo);
    }

    @GetMapping("/getall")
    public DataResult<List<CandidateSchoolInfo>> getAll(){
        return this.candidateSchoolInfoService.getAll();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)//sistemde bu türden bir hata olursa yukrıdaki responseEntity'i bad request ile sarmala //hataları yakala
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors= new HashMap<String, String>();

        for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<>(validationErrors, "false");

        return errors;
    }
}
