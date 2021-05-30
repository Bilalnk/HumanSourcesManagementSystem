package com.kodlama.hrms.core.utilities.adapters.abstracts;

public interface EmailSenderService {

    void sendCode(String email, String code);

}
