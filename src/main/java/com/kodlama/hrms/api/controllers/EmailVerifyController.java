package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.EmailVerificationService;
import com.kodlama.hrms.core.utilities.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/verify")
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
