package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.CandidateLanguagesService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.*;
import com.kodlama.hrms.dataAccess.abstracts.CandidateLanguagesDao;
import com.kodlama.hrms.entities.concretes.CandidateLanguages;
import com.kodlama.hrms.entities.concretes.LanguageLevels;
import com.kodlama.hrms.entities.concretes.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateLanguagesManager implements CandidateLanguagesService {

    private CandidateLanguagesDao candidateLanguagesDao;

    @Autowired
    public CandidateLanguagesManager(CandidateLanguagesDao candidateLanguagesDao) {
        this.candidateLanguagesDao = candidateLanguagesDao;
    }

    @Override
    public DataResult<List<CandidateLanguages>> getAll() {
        return new SuccessDataResult<>(this.candidateLanguagesDao.findAll());
    }

    @Override
    public DataResult<List<CandidateLanguages>> getByCandidateId(int candidateId) {
        return new SuccessDataResult<>(this.candidateLanguagesDao.getByCandidatesId(candidateId));
    }

    @Override
    public Result add(CandidateLanguages candidateLanguages) {
        this.candidateLanguagesDao.save(candidateLanguages);
        return new SuccessResult(Messages.SUCCESS);
    }

    @Override
    public Result update(int id, int languageId, int languageLevelsId) {
        CandidateLanguages candidateLanguages = this.candidateLanguagesDao.findById(id).orElse(null);
        if(candidateLanguages == null ) return new ErrorResult("Bulunamadı");

        Languages languages = new Languages();
        languages.setId(languageId);

        LanguageLevels languageLevels = new LanguageLevels();
        languageLevels.setId(languageLevelsId);

        candidateLanguages.setLanguages(languages);
        candidateLanguages.setLanguageLevels(languageLevels);
        this.candidateLanguagesDao.save(candidateLanguages);
        return new SuccessResult("Güncellendi") ;
    }

}
