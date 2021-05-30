package com.kodlama.hrms.core.utilities.adapters.concretes;

import com.kodlama.hrms.Mernis.MernisService;
import com.kodlama.hrms.core.utilities.adapters.abstracts.UserChecksService;
import com.kodlama.hrms.entities.concretes.Candidates;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements UserChecksService {

    @Override
    public boolean CheckIfRealPerson(Candidates candidates) {
        boolean isReal = false;

        try {
            isReal = MernisService.TCKimlikNoDogrula(Long.parseLong(candidates.getIdentityNumber()), candidates.getFirstName(), candidates.getLastName(), candidates.getBod().getYear());

        } catch (Exception e) {
            System.out.println("HATA: " + e.toString());
        }

        return isReal;
    }
}
