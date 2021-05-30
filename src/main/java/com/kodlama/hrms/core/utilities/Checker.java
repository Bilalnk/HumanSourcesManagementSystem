package com.kodlama.hrms.core.utilities;

import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.core.utilities.result.SuccessResult;

public class Checker {

    public static Result check(Result... results){
        for(Result result: results){
            if(!result.isSuccess()){
                return result;
            }
        }
        return new SuccessResult();
    }

}
