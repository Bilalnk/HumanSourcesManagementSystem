package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.CandidateFavoriteAdvertisementsService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.CandidateFavoriteAdvertisements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/favorites")
@CrossOrigin
public class CandidateFavoriteAdvertisementsController {

    private CandidateFavoriteAdvertisementsService candidateFavoriteAdvertisementsService;

    @Autowired
    public CandidateFavoriteAdvertisementsController(CandidateFavoriteAdvertisementsService candidateFavoriteAdvertisementsService) {
        this.candidateFavoriteAdvertisementsService = candidateFavoriteAdvertisementsService;
    }

    @GetMapping("/getall")
    public DataResult getAll() {
        return this.candidateFavoriteAdvertisementsService.getAll();
    }

    @GetMapping("/getbycandidateid")
    public DataResult getByCandidateId(@RequestParam int id) {
        return this.candidateFavoriteAdvertisementsService.getByCandidateId(id);
    }

    @PostMapping("/addtofavorite")
    public Result add(@RequestBody CandidateFavoriteAdvertisements candidateFavoriteAdvertisements) {
        return this.candidateFavoriteAdvertisementsService.add(candidateFavoriteAdvertisements);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return this.candidateFavoriteAdvertisementsService.delete(id);
    }
}
