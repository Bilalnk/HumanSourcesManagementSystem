package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.SchoolDepartmentService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.entities.concretes.SchoolDepartment;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schooldepartments")
public class SchoolDepartmentController {

    private SchoolDepartmentService departmentService;

    @Autowired
    public SchoolDepartmentController(SchoolDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getall")
    public DataResult<List<SchoolDepartment>> getall(){
        return this.departmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SchoolDepartment schoolDepartment){
        return this.departmentService.add(schoolDepartment);
    }
}