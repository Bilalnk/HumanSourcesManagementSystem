package com.kodlama.hrms.business.concretes;

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

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
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


}
