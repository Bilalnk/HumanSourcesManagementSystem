package com.kodlama.hrms.business.concretes;

import com.kodlama.hrms.business.abstracts.CandidateSchoolInfoService;
import com.kodlama.hrms.business.abstracts.SchoolDepartmentService;
import com.kodlama.hrms.core.utilities.constants.Messages;
import com.kodlama.hrms.core.utilities.result.*;
import com.kodlama.hrms.dataAccess.abstracts.CandidateSchoolInfoDao;
import com.kodlama.hrms.entities.concretes.*;
import com.kodlama.hrms.entities.dtos.SchoolInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateSchoolInfoManager implements CandidateSchoolInfoService {

    private CandidateSchoolInfoDao candidateSchoolInfoDao;
    private SchoolDepartmentService departmentService;

    @Autowired
    public CandidateSchoolInfoManager(CandidateSchoolInfoDao candidateSchoolInfoDao, SchoolDepartmentService departmentService) {
        this.candidateSchoolInfoDao = candidateSchoolInfoDao;
        this.departmentService = departmentService;
    }

    @Override
    public Result add(CandidateSchoolInfo candidateSchoolInfo) {
        if(this.candidateSchoolInfoDao.existsByCandidatesIdAndSchoolDepartmentId(candidateSchoolInfo.getCandidates().getId(), candidateSchoolInfo.getSchoolDepartment().getId())){
            return new ErrorResult("Bu üniversite ve bölüm ile kayıt mevcut");
        }
        this.candidateSchoolInfoDao.save(candidateSchoolInfo);
        return new SuccessResult(Messages.SUCCESS);
    }

    @Override
    public DataResult<List<CandidateSchoolInfo>> getAll() {
        return new SuccessDataResult<List<CandidateSchoolInfo>>(this.candidateSchoolInfoDao.findAll(), Messages.SUCCESS);
    }

    @Override
    public DataResult<List<CandidateSchoolInfo>> getByCandidatesIdOrderByDateOfFinishDesc(int candidateId) {
        return new SuccessDataResult<List<CandidateSchoolInfo>>(this.candidateSchoolInfoDao.getByCandidatesIdOrderByDateOfFinishDesc(candidateId));
    }

    @Override
    public Result update(SchoolInfoDto schoolInfoDto) {
        School school = new School();
        school.setId(schoolInfoDto.getSchoolId());

        Department department = new Department();
        department.setId(schoolInfoDto.getDepartmentId());

        SchoolDepartment schoolDepartment = this.departmentService.getBySchoolIdAndDepartmentId(schoolInfoDto.getSchoolId(), schoolInfoDto.getDepartmentId()).getData();

        CandidateSchoolInfo candidateSchoolInfo = this.candidateSchoolInfoDao.findById(schoolInfoDto.getId()).get();
//        candidateSchoolInfo.setId(schoolInfoDto.getId());
        candidateSchoolInfo.setSchoolDepartment(schoolDepartment);
        candidateSchoolInfo.setDateOfFinish(schoolInfoDto.getFinishDate());
        candidateSchoolInfo.setDateOfStart(schoolInfoDto.getStartDate());
        this.candidateSchoolInfoDao.save(candidateSchoolInfo);
        return new SuccessResult("Güncellendi");
    }

    @Override
    public Result deleteById(int id) {

        if(!this.candidateSchoolInfoDao.existsById(id)) return new ErrorResult("Kayıt bulunamadı. Silme başarısız");

        this.candidateSchoolInfoDao.deleteById(id);
        return new SuccessResult("Silindi");
    }

}
