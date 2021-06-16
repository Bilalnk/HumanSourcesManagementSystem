package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.WorkTypeService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.dataAccess.abstracts.WorkTypeDao;
import com.kodlama.hrms.entities.concretes.WorkType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTypeManager implements WorkTypeService {

    private WorkTypeDao workTypeDao;

    @Autowired
    public WorkTypeManager(WorkTypeDao workTypeDao) {
        this.workTypeDao = workTypeDao;
    }

    @Override
    public DataResult<List<WorkType>> getAll() {
        return new SuccessDataResult<>(this.workTypeDao.findAll());
    }
}
