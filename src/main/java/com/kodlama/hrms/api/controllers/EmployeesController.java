package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.EmployeesService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.Employees;
import com.kodlama.hrms.entities.dtos.EmployeesNameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {

    private EmployeesService employeesService;

    @Autowired
    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employees>> getAll() {

        return this.employeesService.getAll();
    }

    @PostMapping("/update-name")
    public Result updateName(@RequestBody EmployeesNameDto employeesNameDto){

        return this.employeesService.updateName(employeesNameDto);
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public DataResult<Employees> add(@RequestBody Employees employees) {
        return this.employeesService.add(employees);
    }

    @PostMapping("/verifyToEmployer")
    public Result confirmToEmployer(@Valid @RequestParam int id,@Valid @RequestParam boolean active){
        return this.employeesService.confirmEmployer(id, active);
    }

    @GetMapping("/get-by-id")
    public DataResult<Employees> getById(@RequestParam int id){
       return this.employeesService.getById(id);
    }

}
