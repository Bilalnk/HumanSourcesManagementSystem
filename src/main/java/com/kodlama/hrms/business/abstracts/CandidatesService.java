package com.kodlama.hrms.business.abstracts;

import com.kodlama.hrms.entities.concretes.Candidates;

import java.util.List;

public interface CandidatesService {

    List<Candidates> getAll();
}
