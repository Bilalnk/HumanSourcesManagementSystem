package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.WayOfWorkService;
import com.kodlama.hrms.business.concretes.WayOfWorkManager;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.WayOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/wayofwork")
@CrossOrigin
public class WayOfWorkController {

    private WayOfWorkService wayOfWorkService;

    @Autowired
    public WayOfWorkController(WayOfWorkService wayOfWorkService) {
        this.wayOfWorkService = wayOfWorkService;
    }

    @GetMapping("/getall")
    public DataResult<List<WayOfWork>> getAll(){
        return wayOfWorkService.getAll();
    }
}
