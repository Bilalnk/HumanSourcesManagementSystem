package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.CandidatesService;
import com.kodlama.hrms.business.abstracts.EmployeesService;
import com.kodlama.hrms.business.abstracts.EmployersService;
import com.kodlama.hrms.business.abstracts.UserService;
import com.kodlama.hrms.core.utilities.Checker;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.*;
import com.kodlama.hrms.dataAccess.abstracts.UserDao;
import com.kodlama.hrms.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    private CandidatesService candidatesService;
    private EmployersService employersService;
    private EmployeesService employeesService;

    @Autowired
    public UserManager(UserDao userDao, CandidatesService candidatesService, EmployersService employersService, EmployeesService employeesService) {
        this.userDao = userDao;
        this.candidatesService = candidatesService;
        this.employersService = employersService;
        this.employeesService = employeesService;
    }


    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll());
    }

    @Override
    public Result login(String email, String password) {

        if (!this.userDao.existsByEmail(email)) {
            return new ErrorResult("Kullanıcı Bulunamadı");
        }
        if (this.userDao.existsByEmailAndPassword(email, password)) {
            return new SuccessResult("Kullanıcı mevcut");
        }
        return new ErrorResult("Şifrenizi Kontrol Ediniz");
    }

    @Override
    public DataResult<User> getByEmailAndPassword(String email, String password) {

        if (login(email, password).isSuccess()) {
            User user = this.userDao.getByEmailAndPassword(email, password);
            String role = this.candidatesService.isExist(user.getId()) ? "CANDIDATE" :
                    this.employeesService.isExist(user.getId()) ? "EMPLOYEE" :
                            this.employersService.isExist(user.getId()) ? "EMPLOYER" :
                                    "NONE_OF";
            return new SuccessDataResult<>(user, role);
        }
        return new ErrorDataResult<>(null, "Bir Hata Oluştu");
    }

    @Override
    public Result updateMail(int id, String newEmail) {

        User user = this.userDao.findById(id).orElse(null);

        if(user == null){
            return new ErrorResult(Messages.USER_NOT_EXIST);
        }

        user.setEmail(newEmail);
        this.userDao.save(user);

        return new SuccessResult(Messages.UPDATE_SUCCESSFUL);
    }

    @Override
    public Result updatePassword(int id, String oldPassword, String newPassword) {
        User user = this.userDao.findById(id).orElse(null);

        if (user == null) {
            return new ErrorResult(Messages.USER_NOT_EXIST);
        }

        Result passResult = passwordChecker(user, oldPassword, newPassword);

        if(passResult instanceof ErrorResult){
            return passResult;
        }
        if(Checker.check(Checker.emailChecker(newPassword)) instanceof ErrorResult){
            return Checker.check(Checker.emailChecker(newPassword));
        }
        user.setPassword(newPassword);
        this.userDao.save(user);
        return passResult;
    }


    private Result passwordChecker(User user, String oldPassword, String newPassword) {

        if (!oldPassword.equals(user.getPassword())) {
            return new ErrorResult(Messages.INCORRECT_PASSWORD);
        }

        if (newPassword.length() < 6) {
            return new ErrorResult(Messages.PASSWORD_CANNOT_BE_LESS_THEN_SIX_CHARACTERS);
        }

        if (newPassword.isBlank() || newPassword.isEmpty()) {
            return new ErrorResult(Messages.PASSWORD_IS_BLANK);
        }

        return new SuccessResult(Messages.UPDATE_SUCCESSFUL);
    }


}
