package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.LanguageLevelsService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.entities.concretes.LanguageLevels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/langlevel")
@CrossOrigin
public class LanguageLevelsController{

    private LanguageLevelsService languageLevelsService;

    @Autowired
    public LanguageLevelsController(LanguageLevelsService languageLevelsService) {
        this.languageLevelsService = languageLevelsService;
    }

    @PostMapping
    public Result add(@RequestBody LanguageLevels languageLevels){
        this.languageLevelsService.add(languageLevels);
        return new SuccessResult(Messages.SUCCESS);
    }

    @GetMapping("/getall")
    public DataResult<List<LanguageLevels>> getALl(){
        return this.languageLevelsService.getAll();
    }
}
