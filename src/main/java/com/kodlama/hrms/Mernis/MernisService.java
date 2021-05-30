package com.kodlama.hrms.Mernis;

public class MernisService {

    public static boolean TCKimlikNoDogrula(Long identityNumber, String firstName, String lastName, int birthYear){

        return !identityNumber.toString().isBlank() && identityNumber.toString().length()==11 && !firstName.isBlank() && !lastName.isBlank() && birthYear > 0;

    }

}
