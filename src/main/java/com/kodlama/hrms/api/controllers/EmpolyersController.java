package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.EmployersService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.Employers;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmpolyersController {

    private EmployersService employersService;

    public EmpolyersController(EmployersService employersService) {
        this.employersService = employersService;
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public DataResult<Employers> add (@RequestBody Employers employers){
        return this.employersService.add(employers);
    }

    @GetMapping(value = "/getall")
    public DataResult<List<Employers>> getAll(){
        return this.employersService.getAll();
    }

    @GetMapping("/get")
    DataResult<Optional<Employers>> getById(@RequestParam int id){
        return this.employersService.getById(id);
    }




}
