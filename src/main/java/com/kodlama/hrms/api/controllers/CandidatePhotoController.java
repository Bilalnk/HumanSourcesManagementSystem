package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.CandidatePhotoService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.entities.concretes.CandidatePhoto;
import com.kodlama.hrms.entities.concretes.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/uploadphoto")
@CrossOrigin
public class CandidatePhotoController {

    private CandidatePhotoService candidatePhotoService;

    @Autowired
    public CandidatePhotoController(CandidatePhotoService candidatePhotoService) {
        this.candidatePhotoService = candidatePhotoService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody MultipartFile file, @RequestParam int id){
        return this.candidatePhotoService.uploadToCloudinary(file, id);
    }

    @GetMapping("/getall")
    public DataResult<List<CandidatePhoto>> getAll(){
        return this.candidatePhotoService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<List<CandidatePhoto>> getById(@RequestParam int id){
        return this.candidatePhotoService.findByCandidatesId(id);
    }

    @PostMapping("/addpreface")
    public Result addPreface (@RequestParam int candidateId, @RequestParam String preface){
        return this.candidatePhotoService.uploadPreface(candidateId, preface);
    }
}
