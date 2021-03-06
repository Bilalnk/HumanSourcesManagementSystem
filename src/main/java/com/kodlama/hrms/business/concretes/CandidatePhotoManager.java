package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.CandidatePhotoService;
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

@Service
public class CandidatePhotoManager implements CandidatePhotoService {

    private CandidatePhotoDao candidatePhotoDao;
//    private CandidatesService candidatesService;

    private ImageService imageService;

    @Autowired
    public CandidatePhotoManager(CandidatePhotoDao candidatePhotoDao/*, CandidatesService candidatesService*/, ImageService imageService) {
        this.candidatePhotoDao = candidatePhotoDao;
//        this.candidatesService = candidatesService;
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

        if (this.candidatePhotoDao.existsByCandidatesId(id)) {

            return new SuccessDataResult<List<CandidatePhoto>>(this.candidatePhotoDao.findByCandidatesId(id));
        }
        return new ErrorDataResult<>(null, false, "Kullanıcı Fotoğrafı Bulunamadı");
    }

    @Override
    public Result uploadToCloudinary(MultipartFile file, int candidateId) {

        CandidatePhoto candidatePhoto;

        if (this.candidatePhotoDao.existsByCandidatesId(candidateId)) {

            candidatePhoto = this.candidatePhotoDao.getByCandidatesId(candidateId);

        } else {
            Candidates candidates = new Candidates();
            candidates.setId(candidateId);

            candidatePhoto = new CandidatePhoto();
            candidatePhoto.setCandidates(candidates);

        }

        Map<String, String> cloudinaryMap = (Map<String, String>) this.imageService.saveImage(file).getData();

        candidatePhoto.setPhotoUrl(cloudinaryMap.get("url"));
        candidatePhoto.setUploadedDate(LocalDateTime.now());
        this.add(candidatePhoto);
        return new SuccessResult(Messages.PHOTO_UPLOADED);
    }

    @Override
    public Result uploadPreface(int id, String preface) {

        CandidatePhoto candidatePhoto;

        if (this.candidatePhotoDao.existsByCandidatesId(id)) {

            candidatePhoto = this.candidatePhotoDao.getByCandidatesId(id);

        } else {
            Candidates candidates = new Candidates();
            candidates.setId(id);

            candidatePhoto = new CandidatePhoto();
            candidatePhoto.setCandidates(candidates);
        }

        candidatePhoto.setPreface(preface);
        this.candidatePhotoDao.save(candidatePhoto);
        return new SuccessResult(Messages.SUCCESS);


       /*
        try {
            CandidatePhoto candidatePhoto = this.candidatePhotoDao.findByCandidatesId(id).get(0);
            candidatePhoto.setPreface(preface);
            this.candidatePhotoDao.save(candidatePhoto);
            return new SuccessResult(Messages.SUCCESS);
        } catch (Exception e) {
            return new ErrorResult(e.toString());
        }*/
    }


}
