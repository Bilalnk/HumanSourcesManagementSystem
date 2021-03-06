package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.CandidateLanguagesService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.ErrorDataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.entities.concretes.CandidateLanguages;
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
@RequestMapping("/api/candidatelangs")
@CrossOrigin
public class CandidateLanguagesController {

    private CandidateLanguagesService candidateLanguagesService;

    @Autowired
    public CandidateLanguagesController(CandidateLanguagesService candidateLanguagesService) {
        this.candidateLanguagesService = candidateLanguagesService;
    }


    @GetMapping("/getall")
    public DataResult<List<CandidateLanguages>> getAll() {
        return this.candidateLanguagesService.getAll();
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<CandidateLanguages>> getByCandidateId(int candidateId) {
        return this.candidateLanguagesService.getByCandidateId(candidateId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid CandidateLanguages candidateLanguages) {
        return this.candidateLanguagesService.add(candidateLanguages);

    }

    @GetMapping("/update")
    public Result update(@RequestParam int id, @RequestParam int langId, @RequestParam int langLevelId){
        return this.candidateLanguagesService.update(id, langId, langLevelId);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.candidateLanguagesService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
//sistemde bu t??rden bir hata olursa yukr??daki responseEntity'i bad request ile sarmala //hatalar?? yakala
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
//        ErrorDataResult<Object> errors = new ErrorDataResult<>(validationErrors, "false");

        return new ErrorDataResult<>(validationErrors, "False");
    }
}
