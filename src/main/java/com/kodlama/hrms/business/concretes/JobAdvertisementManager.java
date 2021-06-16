package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.JobAdvertisementService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.kodlama.hrms.entities.concretes.JobAdvertisement;
import com.kodlama.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    //TODO DATARESULT -> RESULT
    @Override
    public DataResult<JobAdvertisement> add(JobAdvertisement jobAdvertisement) {
        return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.save(jobAdvertisement), Messages.SUCCESS);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrue(), Messages.SUCCESS);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrueOrderByPublishedDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueOrderByPublishedDateDesc(), Messages.SUCCESS);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveTrueAndEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByActiveTrueAndEmployerId(employerId));
    }

    @Override
    public Result updateAdvertisementActive(int id, boolean active) {
        JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(id).orElse(null);
        jobAdvertisement.setActive(active);
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> getJobAdveritsementDetails() {
        return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementByDetails());
    }

    @Override
    public DataResult<Optional<JobAdvertisement>> getById(int id) {
        return new SuccessDataResult<Optional<JobAdvertisement>>(this.jobAdvertisementDao.findById(id));
    }


}
