package com.kodlama.hrms.entities.dtos;

import com.kodlama.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CVDto {

    private Candidates candidate;
    private List<CandidateSchoolInfo> candidateSchoolInfoList;
    private List<CandidateLanguages> candidateLanguages;
    private List<Experience> experiences;
    private List<CandidateLinks> candidateLinks;
    private List<CandidateSkills> candidateSkills;
    private List<CandidatePhoto> candidatePhoto;

//    private Candidates candidate;
//    private CandidateSchoolInfo candidateSchoolInfo;
//    private CandidateLanguages candidateLanguages;
//    private Experience experience;
//    private CandidateLinks candidateLinks;
//    private CandidateSkills candidateSkills;
}
