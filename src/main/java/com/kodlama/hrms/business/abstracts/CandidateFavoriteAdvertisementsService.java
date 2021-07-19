package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.concretes.CandidateFavoriteAdvertisements;

import java.util.List;

public interface CandidateFavoriteAdvertisementsService {

    DataResult<List<CandidateFavoriteAdvertisements>> getAll();

    DataResult<List<CandidateFavoriteAdvertisements>> getByCandidateId(int id);

    Result add(CandidateFavoriteAdvertisements candidateFavoriteAdvertisements);

    Result delete(int id);

}
