package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.LanguagesService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lang")
public class LanguagesController {

    private LanguagesService languagesService;

    @Autowired
    public LanguagesController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Languages languages){
        return this.languagesService.add(languages);
    }

    @GetMapping("/getall")
    public DataResult<List<Languages>> getAll(){
        return this.languagesService.getAll();
    }
}
