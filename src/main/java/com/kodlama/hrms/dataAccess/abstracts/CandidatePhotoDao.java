package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.CandidatePhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidatePhotoDao extends JpaRepository<CandidatePhoto, Integer> {

    List<CandidatePhoto> findByCandidatesId(int id);

    CandidatePhoto getByCandidatesId(int id);

    boolean existsByCandidatesId(int candidateId);

}
