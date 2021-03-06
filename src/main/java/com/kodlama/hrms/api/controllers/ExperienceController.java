package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.ExperienceService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.*;
import com.kodlama.hrms.entities.concretes.Experience;
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
@RequestMapping("/api/experience")
@CrossOrigin
public class ExperienceController {

    private ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody Experience experience) {
        return this.experienceService.add(experience);
    }

    @GetMapping("/getall")
    public DataResult<List<Experience>> getAll() {
        return this.experienceService.getAll();
    }

    @GetMapping("/getalldesc")
    public DataResult<List<Experience>> getAllDesc(){
        return this.experienceService.getAll();
    }

    @GetMapping("/getbycandidateId")
    public DataResult<List<Experience>> getByCandidateIdOrderByDesc(@RequestParam int candidateId){
        return this.experienceService.findByCandidatesIdOrderByDepartureDateDesc(candidateId);
    }

    @DeleteMapping("/delete")
    public Result delete (@RequestParam int id){
        return this.experienceService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)//sistemde bu türden bir hata olursa yukarıdaki responseEntity'i bad request ile sarmala //hataları yakala
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
