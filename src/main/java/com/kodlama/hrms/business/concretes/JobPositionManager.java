package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.JobPositionService;
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
    public List<JobPositions> getAll() {
        return this.jobPositionsDao.findAll();
    }

    @Override
    public Optional<JobPositions> getById(int id) {

        return this.jobPositionsDao.findById(id);
    }

    @Override
    public List<JobPositions> getByName(String position) {
        return this.jobPositionsDao.getJobPositionsByPosition(position);
    }

    @Override
    public JobPositions saveJobPosition(JobPositions jobPositions) {
        return this.jobPositionsDao.save(jobPositions);
    }

    @Override
    public void delete(int id) {
        this.jobPositionsDao.deleteById(id);

    }

    @Override
    public JobPositions updateById(int id, JobPositions newJobPositions) {
        return getById(id)
                .map(position -> {
                    position.setPosition(newJobPositions.getPosition());
                    return saveJobPosition(position);
                })
                .orElseGet(() -> {
                    //newJobPositions.setId(id);
                    return saveJobPosition(newJobPositions);
                });
    }
}
