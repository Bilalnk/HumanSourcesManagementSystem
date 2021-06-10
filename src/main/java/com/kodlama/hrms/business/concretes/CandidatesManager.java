package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.*;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.adapters.abstracts.EmailSenderService;
import com.kodlama.hrms.core.utilities.adapters.abstracts.UserChecksService;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.ErrorDataResult;
import com.kodlama.hrms.core.utilities.result.SuccessDataResult;
import com.kodlama.hrms.dataAccess.abstracts.CandidatesDao;
import com.kodlama.hrms.entities.concretes.Candidates;
import com.kodlama.hrms.entities.dtos.CVDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CandidatesManager implements CandidatesService {

    private CandidatesDao candidatesDao;
    private UserChecksService userChecksService;
    private EmailSenderService emailSenderService;
    private EmailVerificationService emailVerificationService;
    private CandidateSchoolInfoService candidateSchoolInfoService;
    private CandidateLanguagesService candidateLanguagesService;
    private ExperienceService experienceService;
    private CandidateLinksService candidateLinksService;
    private CandidateSkillsService skillsService;
//    private CandidatePhotoService candidatePhotoService;

    @Autowired
    public CandidatesManager(CandidatesDao candidatesDao, UserChecksService userChecksService, EmailSenderService emailSenderService,
                             EmailVerificationService emailVerificationService, CandidateSchoolInfoService candidateSchoolInfoService,
                             CandidateLanguagesService candidateLanguagesService, ExperienceService experienceService,
                             CandidateLinksService candidateLinksService, CandidateSkillsService skillsService/*, CandidatePhotoService candidatePhotoService*/) {
        this.candidatesDao = candidatesDao;
        this.userChecksService = userChecksService;
        this.emailSenderService = emailSenderService;
        this.emailVerificationService = emailVerificationService;
        this.candidateSchoolInfoService = candidateSchoolInfoService;
        this.candidateLanguagesService = candidateLanguagesService;
        this.experienceService = experienceService;
        this.candidateLinksService = candidateLinksService;
        this.skillsService = skillsService;
//        this.candidatePhotoService = candidatePhotoService;
    }


    @Override
    public DataResult<List<Candidates>> getAll() {
        return new SuccessDataResult<List<Candidates>>(this.candidatesDao.findAll(), Messages.USERS_RETURNED);
    }

    @Override
    public DataResult<Optional<Candidates>> getById(int id) {
        Optional<Candidates> candidates = this.candidatesDao.findById(id);
        if (candidates.isEmpty()) {
            return new ErrorDataResult<>(null, false, Messages.USER_NOT_EXIST);
        }
        return new SuccessDataResult<Optional<Candidates>>(this.candidatesDao.findById(id), Messages.USER_RETURNED);
    }

    @Override
    public DataResult<Candidates> add(Candidates candidates) {

        if(!CandidatesFieldChecker.checker(candidates)){
            return new ErrorDataResult<>(candidates, false, Messages.NOT_IN_PROPER_FORMAT);
        }if (!userChecksService.CheckIfRealPerson(candidates)) {
            return new ErrorDataResult<Candidates>(candidates, false, Messages.NOT_A_REAL_PERSON);
        }if(candidatesDao.existsCandidatesByEmail(candidates.getEmail())){
            return new ErrorDataResult<Candidates>(candidates, false, Messages.EMAIL_EXIST);
        }if(candidatesDao.existsCandidatesByIdentityNumber(candidates.getIdentityNumber())){
            return new ErrorDataResult<Candidates>(candidates, false, Messages.IDENTITY_NUMBER_EXIST);
        }

        Candidates candidates1 = this.candidatesDao.save(candidates);
        this.emailSenderService.sendCode(candidates.getEmail(), this.emailVerificationService.createCode(candidates1.getId()));
        return new SuccessDataResult<Candidates>(candidates1, Messages.USER_ADDED);

    }

    @Override
    public boolean isExist(int id) {
        return this.candidatesDao.existsCandidatesById(id);
    }

    @Override
    public DataResult<CVDto> getCvById(int id) {

        if(!this.isExist(id)) return new ErrorDataResult<>(null, Messages.USER_NOT_EXIST);

        CVDto cvDto= new CVDto();
        cvDto.setCandidate(this.candidatesDao.findById(id).get());
        cvDto.setCandidateSchoolInfoList(this.candidateSchoolInfoService.getByCandidatesIdOrderByDateOfFinishDesc(id).getData());
        cvDto.setCandidateLanguages(this.candidateLanguagesService.getAll().getData());
        cvDto.setExperiences(this.experienceService.findByCandidatesIdOrderByDepartureDateDesc(id).getData());
        cvDto.setCandidateLinks(this.candidateLinksService.getAll().getData());
        cvDto.setCandidateSkills(this.skillsService.getAll().getData());
//        cvDto.setCandidatePhoto(this.candidatePhotoService.findByCandidatesId(id).getData());

        return new SuccessDataResult<>(cvDto, Messages.SUCCESS);
    }
}

class CandidatesFieldChecker{

    public static boolean checker(Candidates candidates){

        return !candidates.getEmail().isBlank() && !candidates.getFirstName().isBlank() && !candidates.getLastName().isBlank() &&
                    !candidates.getIdentityNumber().isBlank() && candidates.getIdentityNumber().length() == 11 && !candidates.getEmail().isBlank() && emailVerify(candidates.getEmail());

    }

    private static boolean emailVerify(String email){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
