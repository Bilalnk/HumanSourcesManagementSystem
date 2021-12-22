package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.CandidateFavoriteAdvertisementsService;
import com.kodlama.hrms.business.abstracts.CandidatesService;
import com.kodlama.hrms.core.utilities.result.*;
import com.kodlama.hrms.dataAccess.abstracts.CandidateFavoriteAdvertisementsDao;
import com.kodlama.hrms.entities.concretes.CandidateFavoriteAdvertisements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateFavoriteAdvertisementsManager implements CandidateFavoriteAdvertisementsService{


    private CandidateFavoriteAdvertisementsDao candidateFavoriteAdvertiesementsDao;
    private CandidatesService candidatesService;

    @Autowired
    public CandidateFavoriteAdvertisementsManager(CandidateFavoriteAdvertisementsDao candidateFavoriteAdvertiesementsDao, CandidatesService candidatesService) {
        this.candidateFavoriteAdvertiesementsDao = candidateFavoriteAdvertiesementsDao;
        this.candidatesService = candidatesService;
    }

    @Override
    public DataResult<List<CandidateFavoriteAdvertisements>> getAll() {
        return new SuccessDataResult<>(this.candidateFavoriteAdvertiesementsDao.findAll());
    }

    @Override
    public DataResult<List<CandidateFavoriteAdvertisements>> getByCandidateId(int id) {
        return new SuccessDataResult<>(this.candidateFavoriteAdvertiesementsDao.getByCandidatesId(id));
    }

    @Override
    public Result add(CandidateFavoriteAdvertisements candidateFavoriteAdvertisements) {
        boolean isExistJobadvertisement = this.candidateFavoriteAdvertiesementsDao.existsByJobAdvertisementId(candidateFavoriteAdvertisements.getJobAdvertisement().getId());
        boolean isExistCandidate = candidatesService.isExist(candidateFavoriteAdvertisements.getCandidates().getId()); 

        if(!isExistCandidate){
            return new ErrorResult("Aday Bulunamadı");
        }
        if(isExistJobadvertisement){
            return new ErrorResult("Bu İş İlanı Zaten Favorilerde ");
        }

        this.candidateFavoriteAdvertiesementsDao.save(candidateFavoriteAdvertisements);
        return new SuccessResult("Eklendi");
    }

    @Override
    public Result delete(int id) {
        if(!this.candidateFavoriteAdvertiesementsDao.existsById(id)){
            return new ErrorResult("Kayıt bulunamadı");
        }
        this.candidateFavoriteAdvertiesementsDao.deleteById(id);
        return new SuccessResult("Silindi");
    }
}
