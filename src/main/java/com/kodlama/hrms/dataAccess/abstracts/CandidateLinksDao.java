package com.kodlama.hrms.dataAccess.abstracts;

import com.kodlama.hrms.entities.concretes.CandidateLinks;
import com.kodlama.hrms.entities.dtos.CandidateLinksDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateLinksDao extends JpaRepository<CandidateLinks, Integer> {

    CandidateLinks findByCandidatesId(int id);

    List<CandidateLinks> getByCandidatesId(int id);

    @Query("select new com.kodlama.hrms.entities.dtos.CandidateLinksDto(l.linkType.type, l.link) from CandidateLinks l where l.candidates.id = :id")
    List<CandidateLinksDto> getAllByCandidatesId(int id);


}
