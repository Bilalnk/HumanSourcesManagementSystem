package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.CandidatePhoto;
import com.kodlama.hrms.entities.concretes.Candidates;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CandidatePhotoService {

    Result add(CandidatePhoto candidatePhoto);

    DataResult<List<CandidatePhoto>> getAll();

    DataResult<List<CandidatePhoto>> findByCandidatesId(int id);

    Result uploadToCloudinary(MultipartFile file, int candidateId);

}
