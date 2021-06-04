package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.DepartmentService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.dataAccess.abstracts.DepartmentDao;
import com.kodlama.hrms.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public DataResult<List<Department>> getAll() {
        return new SuccessDataResult<>(this.departmentDao.findAll(), Messages.SUCCESS);
    }

    @Override
    public Result add(Department department) {
        this.departmentDao.save(department);
        return new SuccessResult("Eklendi");
    }

    @Override
    public DataResult<List<Department>> findByName(String name) {
        return new SuccessDataResult<>(this.departmentDao.findByDepartmentName(name));
    }
}
