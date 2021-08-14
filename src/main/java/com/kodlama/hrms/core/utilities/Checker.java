package com.kodlama.hrms.core.utilities;

import com.kodlama.hrms.core.utilities.result.ErrorResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

    public static Result check(Result... results){
        for(Result result: results){
            if(!result.isSuccess()){
                return result;
            }
        }
        return new SuccessResult();
    }

    public static Result emailChecker(String email){

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches() ? new SuccessResult() : new ErrorResult();

    }


}
