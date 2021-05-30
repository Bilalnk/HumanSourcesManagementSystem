package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.JobPositionService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessResult;
import com.kodlama.hrms.dataAccess.abstracts.JobPositionsDao;
import com.kodlama.hrms.entities.concretes.JobPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionsDao jobPositionsDao;

    @Autowired
    public JobPositionManager(JobPositionsDao jobPositionsDao) {
        this.jobPositionsDao = jobPositionsDao;
    }

    @Override
    public DataResult<List<JobPositions>> getAll() {
        return new SuccessDataResult<List<JobPositions>>(this.jobPositionsDao.findAll(), "OK, Success");
    }

    @Override
    public DataResult<Optional<JobPositions>> getById(int id) {

        return new SuccessDataResult<Optional<JobPositions>>(this.jobPositionsDao.findById(id), "Success");
    }

    @Override
    public DataResult<List<JobPositions>> getByName(String position) {
        return new SuccessDataResult<List<JobPositions>>(this.jobPositionsDao.getJobPositionsByPosition(position), "query get by name is successful");
    }

    @Override
    public DataResult<JobPositions> saveJobPosition(JobPositions jobPositions) {
        return new SuccessDataResult<JobPositions>(this.jobPositionsDao.save(jobPositions), "Eklendi");
    }

    @Override
    public SuccessResult delete(int id) {
        this.jobPositionsDao.deleteById(id);
        return new SuccessResult( "Silindi");
    }

    //TODO BURADA SORUN VAR ÖNCE EKLEME SONRA GÜNCELLME YAPIYOR
    @Override
    public SuccessDataResult<JobPositions> updateById(int id, JobPositions newJobPositions) {
        return new SuccessDataResult<>();

        /*this.jobPositionsDao.getById(id)
                .map(position -> {
                    System.out.println(position.getPosition());
                    position.setPosition(newJobPositions.getPosition());
                    return new SuccessDataResult<JobPositions> (this.jobPositionsDao.save(newJobPositions), "guncellendi");
                })
                .orElseGet(() -> {
                    //newJobPositions.setId(id);
                    return (SuccessDataResult<JobPositions>) saveJobPosition(newJobPositions);
                });*/
    }
}
