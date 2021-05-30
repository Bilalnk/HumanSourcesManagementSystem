package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.abstracts.User;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();


//    DataResult<User> add(User user);

}
