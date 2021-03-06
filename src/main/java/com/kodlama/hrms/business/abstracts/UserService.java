package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.abstracts.User;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();

    Result login(String email, String password);

    DataResult<User> getByEmailAndPassword(String email, String password);

    Result updateMail(int id, String email);

    Result updatePassword(int id, String oldPassword, String newPassword);

//    DataResult<User> add(User user);

}
