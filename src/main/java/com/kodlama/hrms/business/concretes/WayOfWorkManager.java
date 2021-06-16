package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.WayOfWorkService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.dataAccess.abstracts.WayOfWorkDao;
import com.kodlama.hrms.entities.concretes.WayOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WayOfWorkManager implements WayOfWorkService {

    private WayOfWorkDao wayOfWorkDao;

    @Autowired
    public WayOfWorkManager(WayOfWorkDao wayOfWorkDao) {
        this.wayOfWorkDao = wayOfWorkDao;
    }

    @Override
    public DataResult<List<WayOfWork>> getAll() {
        return new SuccessDataResult<List<WayOfWork>>(this.wayOfWorkDao.findAll(), Messages.SUCCESS);
    }
}
