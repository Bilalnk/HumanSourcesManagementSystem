package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.ActivationCodes;

public interface EmailVerificationService {

    String createCode(int id);

    Result verify(String activationCode, int id);

}
