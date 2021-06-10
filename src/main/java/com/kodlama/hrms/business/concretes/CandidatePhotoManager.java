package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.CandidatePhotoService;
import com.kodlama.hrms.business.abstracts.CandidatesService;
import com.kodlama.hrms.core.utilities.cloudinary.abstracts.ImageService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.*;
import com.kodlama.hrms.dataAccess.abstracts.CandidatePhotoDao;
import com.kodlama.hrms.entities.concretes.CandidatePhoto;
import com.kodlama.hrms.entities.concretes.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class CandidatePhotoManager implements CandidatePhotoService {

    private CandidatePhotoDao candidatePhotoDao;
    private CandidatesService candidatesService;

    private ImageService imageService;

    @Autowired
    public CandidatePhotoManager(CandidatePhotoDao candidatePhotoDao, CandidatesService candidatesService, ImageService imageService) {
        this.candidatePhotoDao = candidatePhotoDao;
        this.candidatesService = candidatesService;
        this.imageService = imageService;
    }


    @Override
    public Result add(CandidatePhoto candidatePhoto) {
        this.candidatePhotoDao.save(candidatePhoto);
        return new SuccessResult(Messages.SUCCESS);

    }

    @Override
    public DataResult<List<CandidatePhoto>> getAll() {
        return new SuccessDataResult<List<CandidatePhoto>>(this.candidatePhotoDao.findAll());
    }

    @Override
    public DataResult<List<CandidatePhoto>> findByCandidatesId(int id) {
        return new SuccessDataResult<List<CandidatePhoto>>(this.candidatePhotoDao.findByCandidatesId(id));
    }

    @Override
    public Result uploadToCloudinary(MultipartFile file, int candidateId) {

        if (!this.candidatesService.isExist(candidateId)) return new ErrorResult(Messages.USER_NOT_EXIST);

        Optional<Candidates> candidates = this.candidatesService.getById(candidateId).getData();
        Map<String, String> cloudinaryMap = (Map<String, String>) this.imageService.saveImage(file).getData();


        CandidatePhoto candidatePhoto = null;
        CandidatePhoto candidatePhotoEx = this.candidatePhotoDao.findByCandidatesId(candidateId).get(0);
        candidatePhoto = Objects.requireNonNullElseGet(candidatePhotoEx, CandidatePhoto::new);
        candidatePhoto.setCandidates(candidates.get());
        candidatePhoto.setPhotoUrl(cloudinaryMap.get("url"));
        candidatePhoto.setUploadedDate(LocalDateTime.now());
        this.add(candidatePhoto);
        return new SuccessResult(Messages.PHOTO_UPLOADED);
    }
}
