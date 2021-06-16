package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.EmailVerificationService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.ErrorDataResult;
import com.kodlama.hrms.core.utilities.result.ErrorResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.dataAccess.abstracts.ActivationCodesDao;
import com.kodlama.hrms.entities.concretes.ActivationCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Service
public class EmailVerificationManager implements EmailVerificationService {

    public static final char[] CHARS = {'0','1', '2', '3', '4', '5', '6', '7', '8',
            '9','a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    Random random = new Random();


    private ActivationCodesDao activationCodesDao;

    @Autowired
    public EmailVerificationManager(ActivationCodesDao activationCodesDao) {
        this.activationCodesDao = activationCodesDao;
    }

    @Override
    public String createCode(int id) {
        String createdCode = getCode();
        ActivationCodes activationCode = new ActivationCodes();
        activationCode.setActivationCode(createdCode);
        activationCode.setConfirmed(false);
        activationCode.setUserId(id);

        this.activationCodesDao.save(activationCode);
        return createdCode;
    }

    @Override
    public Result verify(String code, int id) {
        Optional<ActivationCodes> getCode = this.activationCodesDao.findByUserId(id);
        if(!getCode.isPresent()) return new ErrorResult("Kullanıcı bulunamadı");

        ActivationCodes activationCode = getCode.get();

        if(activationCode.getActivationCode().equals(code)){
            if(!activationCode.isConfirmed()){
                activationCode.setConfirmed(true);
                activationCode.setConfirmDate(new Date());
                return new SuccessDataResult<ActivationCodes>(this.activationCodesDao.save(activationCode), Messages.SUCCESS);
            }else {
                return new ErrorDataResult<String>(code, false, "hesap zaten doğrulanmış");
            }
        }
        return new ErrorResult("Geçersiz aktivasyon kodu!");

    }

    public String getCode(){
        StringBuffer buffer = new StringBuffer();

        for(int i = 0; i < 9; i++){
            buffer.append(CHARS[random.nextInt(CHARS.length)]);
        }
        return buffer.toString();
    }
}
