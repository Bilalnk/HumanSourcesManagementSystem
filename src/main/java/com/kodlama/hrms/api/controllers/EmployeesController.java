package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.EmployeesService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emplooyes")
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

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public DataResult<Employees> add(@RequestBody Employees employees) {
        return this.employeesService.add(employees);
    }

}
