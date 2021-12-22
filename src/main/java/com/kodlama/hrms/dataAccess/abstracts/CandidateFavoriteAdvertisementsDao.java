package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.entities.concretes.CandidateFavoriteAdvertisements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateFavoriteAdvertisementsDao extends JpaRepository<CandidateFavoriteAdvertisements, Integer> {

    List<CandidateFavoriteAdvertisements> getByCandidatesId(int id);

    boolean existsByJobAdvertisementId(int jobId);

}
