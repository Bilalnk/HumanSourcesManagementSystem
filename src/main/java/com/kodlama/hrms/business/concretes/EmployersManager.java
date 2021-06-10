package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.EmailVerificationService;
import com.kodlama.hrms.business.abstracts.EmployersService;
import com.kodlama.hrms.core.utilities.Checker;
import com.kodlama.hrms.core.utilities.adapters.abstracts.EmailSenderService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.*;
import com.kodlama.hrms.dataAccess.abstracts.EmployersDao;
import com.kodlama.hrms.entities.concretes.Employers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployersManager implements EmployersService {

    private EmployersDao employersDao;
    private EmailSenderService emailSenderService;
    private EmailVerificationService emailVerificationService;

    @Autowired
    public EmployersManager(EmployersDao employersDao, EmailSenderService emailSenderService, EmailVerificationService emailVerificationService) {
        this.employersDao = employersDao;
        this.emailSenderService = emailSenderService;
        this.emailVerificationService = emailVerificationService;
    }

    @Override
    public DataResult<Employers> add(Employers employers) {

        Result checked = Checker.check(checkCompanyName(employers), checkWebAddress(employers), checkPhoneNumber(employers), checkExistUser(employers), checkPassword(employers));

        if (!checked.isSuccess()) {
            return new ErrorDataResult<Employers>(null, false, checked.getMessage());
        }

        Employers employers1 = this.employersDao.save(employers);
        this.emailSenderService.sendCode(employers.getEmail(), this.emailVerificationService.createCode(employers1.getId()));
        return new SuccessDataResult<Employers>(employers1, Messages.USER_ADDED);
    }

    @Override
    public DataResult<List<Employers>> getAll() {
        return new SuccessDataResult<List<Employers>>(this.employersDao.findAll(), Messages.USERS_RETURNED);
    }

    @Override
    public Result confirmEmployer(int id, boolean active) {
        Employers employers = this.employersDao.findById(id).orElse(null);
        if(employers == null) return new ErrorResult(Messages.USER_NOT_EXIST);
        employers.setActivated(active);
        this.employersDao.save(employers);
        return new SuccessResult(Messages.SUCCESS);
    }


    private Result checkCompanyName(Employers employers) {
        if (employers.getCompanyName().isBlank() || employers.getCompanyName() == null) {
            return new ErrorResult(Messages.COMPANY_NAME_NOT_NULL);
        }
        return new SuccessResult();
    }

    private Result checkWebAddress(Employers employers) {

        //TODO domaine göre eşleşen regex yaz
        //TODO email için regex yaz
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employers.getEmail());

        if (employers.getWebAddress().isBlank() || employers.getWebAddress() == null) {
            return new ErrorResult(Messages.COMPANY_WEB_ADDRESS_NOT_NULL);
        }
        if (!employers.getEmail().contains(employers.getWebAddress())) {
            return new ErrorResult(Messages.COMPANY_DOMAIN_NOT_MATCHED);
        }
        return new SuccessResult();
    }

    private Result checkPhoneNumber(Employers employers) {

        String regex = "((?<area>\\+\\d{1,2})[ -])?\\(?(?<operator>\\d{3})\\)?[ -]?(?<main>\\d{3})[ -]?(?<number>\\d{4})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employers.getPhoneNumber());
        if (!matcher.matches()) {
            return new ErrorResult(Messages.INVALID_PHONE_NUMBER);
        }
        return new SuccessResult();
    }

    private Result checkExistUser(Employers employers) {

        if (this.employersDao.existsByEmail(employers.getEmail())) {
            return new ErrorResult(Messages.EMAIL_EXIST);
        }
        return new SuccessResult();
    }

    private Result checkPassword(Employers employers) {
        if (employers.getPassword().isBlank() || employers.getPassword() == null) {
            return new ErrorResult(Messages.PASSWORD_IS_BLANK);
        }
        return new SuccessResult();
    }

}


