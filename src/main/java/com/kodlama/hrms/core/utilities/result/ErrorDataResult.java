package com.kodlama.hrms.core.utilities.result;

public class ErrorDataResult<T> extends DataResult<T>{

    public ErrorDataResult() {
        super(null, false);
    }

    public ErrorDataResult(T data, boolean success){
        super(data, false);
    }

    public ErrorDataResult(T data, boolean success, String message){
        super(data, success, message);
    }
}
