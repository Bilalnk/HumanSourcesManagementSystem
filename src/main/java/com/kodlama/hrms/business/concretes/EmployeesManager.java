package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.EmployeesService;
import com.kodlama.hrms.business.abstracts.EmployersService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.dataAccess.abstracts.EmployeesDao;
import com.kodlama.hrms.entities.concretes.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesManager implements EmployeesService {

    private EmployeesDao employeesDao;
    private EmployersService employersService;

    @Autowired
    public EmployeesManager(EmployeesDao employeesDao, EmployersService employersService) {
        this.employeesDao = employeesDao;
        this.employersService = employersService;
    }


    @Override
    public DataResult<List<Employees>> getAll() {
        return new SuccessDataResult<>(this.employeesDao.findAll(), "successed: get all employees invoked");
    }

    @Override
    public DataResult<Employees> add(Employees employees) {
        return new SuccessDataResult<>(this.employeesDao.save(employees), "added");
    }

    @Override
    public Result confirmEmployer(int id, boolean active) {
        return employersService.confirmEmployer(id, active);
    }
}
