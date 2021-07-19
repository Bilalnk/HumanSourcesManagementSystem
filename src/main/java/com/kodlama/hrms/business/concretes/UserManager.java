package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.CandidatesService;
import com.kodlama.hrms.business.abstracts.EmployeesService;
import com.kodlama.hrms.business.abstracts.EmployersService;
import com.kodlama.hrms.business.abstracts.UserService;
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

        if(!this.userDao.existsByEmail(email)){
            return new ErrorResult("Kullanıcı Bulunamadı");
        }
        if (this.userDao.existsByEmailAndPassword(email, password)) {
            return new SuccessResult("Kullanıcı mevcut");
        }
        return new ErrorResult("Şifrenizi Kontrol Ediniz");
    }

    @Override
    public DataResult<User> getByEmailAndPassword(String email, String password) {

        if(login(email,password).isSuccess()){
            User user = this.userDao.getByEmailAndPassword(email, password);
            String role = this.candidatesService.isExist(user.getId()) ? "CANDIDATE" :
                    this.employeesService.isExist(user.getId()) ? "EMPLOYEE" :
                    this.employersService.isExist(user.getId()) ? "EMPLOYER" :
                    "NONE_OF";
            return new SuccessDataResult<>(user, role);
        }
        return new ErrorDataResult<>(null, "Bir Hata Oluştu");
    }


}
