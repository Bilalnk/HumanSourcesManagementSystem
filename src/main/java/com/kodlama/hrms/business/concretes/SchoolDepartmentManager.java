package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.SchoolDepartmentService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.dataAccess.abstracts.SchoolDepartmentDao;
import com.kodlama.hrms.entities.concretes.SchoolDepartment;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService {

    private SchoolDepartmentDao departmentDao;

    @Autowired
    public SchoolDepartmentManager(SchoolDepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Result add(SchoolDepartment schoolDepartment) {
        this.departmentDao.save(schoolDepartment);
        return new SuccessResult(Messages.SUCCESS);
    }

    @Override
    public DataResult<List<SchoolDepartment>> getAll() {
        return new SuccessDataResult<>(this.departmentDao.findAll(), Messages.SUCCESS);
    }
}
