package com.kodlama.hrms.core.utilities.adapters.concretes;

import com.kodlama.hrms.core.utilities.adapters.abstracts.EmailSenderService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmailSenderAdapter implements EmailSenderService {


    @Override
    public void sendCode(String email, String code) {

        System.out.println(email + " adresinde "+ code + " kodu gönderildi.");


    }


}
