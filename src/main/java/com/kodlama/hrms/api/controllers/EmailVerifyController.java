package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.EmailVerificationService;
import com.kodlama.hrms.core.utilities.result.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/verify")
@CrossOrigin
public class EmailVerifyController {

    private EmailVerificationService emailVerificationService;

    public EmailVerifyController(EmailVerificationService emailVerificationService) {
        this.emailVerificationService = emailVerificationService;
    }

    @PostMapping("/{id}/{activationCode}")
    public Result verify(@RequestParam int id, @RequestParam  String activationCode){
        return this.emailVerificationService.verify(activationCode, id);
    }
}
