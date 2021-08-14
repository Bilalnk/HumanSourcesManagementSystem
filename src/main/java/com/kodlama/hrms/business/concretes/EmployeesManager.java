package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.EmployeesService;
import com.kodlama.hrms.business.abstracts.EmployersService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.*;
import com.kodlama.hrms.dataAccess.abstracts.EmployeesDao;
import com.kodlama.hrms.entities.concretes.Employees;
import com.kodlama.hrms.entities.dtos.EmployeesNameDto;
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
    public DataResult<Employees> getById(int id) {

        Employees employees = this.employeesDao.findById(id).orElse(null);

        return employees != null ? new SuccessDataResult<>(employees) : new ErrorDataResult<>(null, Messages.USER_NOT_EXIST);
    }

    @Override
    public DataResult<Employees> add(Employees employees) {
        return new SuccessDataResult<>(this.employeesDao.save(employees), "added");
    }

    @Override
    public Result confirmEmployer(int id, boolean active) {
        return employersService.confirmEmployer(id, active);
    }

    @Override
    public boolean isExist(int employeesId) {
        return this.employeesDao.existsById(employeesId);
    }

    @Override
    public Result updateName(EmployeesNameDto employeesNameDto) {

        Employees myEmployees = this.employeesDao.findById(employeesNameDto.getId()).orElse(null);

        if(myEmployees != null){
            myEmployees.setFirstName(employeesNameDto.getName());
            myEmployees.setLastName(employeesNameDto.getSurname());
            this.employeesDao.save(myEmployees);
            return new SuccessResult(Messages.UPDATE_SUCCESSFUL);
        }
        return new ErrorResult(Messages.USER_NOT_EXIST);
    }


}
