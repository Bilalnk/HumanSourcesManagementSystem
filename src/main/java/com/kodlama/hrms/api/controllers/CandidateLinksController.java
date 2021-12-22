package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.CandidateLinksService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.ErrorDataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.CandidateLinks;
import com.kodlama.hrms.entities.dtos.CandidateLinksDto;
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
@RequestMapping("/api/candidatelinks")
@CrossOrigin
public class CandidateLinksController {

    private CandidateLinksService candidateLinksService;

    @Autowired
    public CandidateLinksController(CandidateLinksService candidateLinksService) {
        this.candidateLinksService = candidateLinksService;
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody CandidateLinks candidateLinks){
        return this.candidateLinksService.add(candidateLinks);
    }

    @GetMapping("/getall")
    public DataResult<List<CandidateLinks>> getAll(){
        return this.candidateLinksService.getAll();
    }

    @GetMapping("/getbycandidateId")
    public DataResult<List<CandidateLinks>> getByCandidateId(@RequestParam int id){
        return this.candidateLinksService.getByCandidateId(id);
    }

    @GetMapping("/getlinksdtosbycandidateid")
    public DataResult<List<CandidateLinksDto>> getAllDtoByCandidateId(@RequestParam int id){
        return this.candidateLinksService.getAllDtoByCandidateId(id);
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
