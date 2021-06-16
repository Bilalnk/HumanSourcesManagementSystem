package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.WorkTypeService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/worktype")
@CrossOrigin
public class WorkTypeController {

    private WorkTypeService workTypeService;

    @Autowired
    public WorkTypeController(WorkTypeService workTypeService) {
        this.workTypeService = workTypeService;
    }

    @GetMapping("/getall")
    public DataResult<List<WorkType>> getAll(){
        return this.workTypeService.getAll();
    }
}
