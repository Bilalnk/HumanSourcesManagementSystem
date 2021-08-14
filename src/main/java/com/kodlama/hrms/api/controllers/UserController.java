package com.kodlama.hrms.api.controllers;

import com.kodlama.hrms.business.abstracts.UserService;
import com.kodlama.hrms.business.concretes.UserManager;
import com.kodlama.hrms.core.utilities.result.DataResult;
import com.kodlama.hrms.core.utilities.result.ErrorDataResult;
import com.kodlama.hrms.core.utilities.result.Result;
import com.kodlama.hrms.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public Result login(@Valid @RequestParam String email, @Valid @RequestParam String password ){
        return this.userService.login(email, password);
    }

    @GetMapping("/loginandget")
    public DataResult<User> getUser (@RequestParam String email, @Valid @RequestParam String password ){
        return this.userService.getByEmailAndPassword(email, password);
    }

    @PostMapping("/update-mail")
    public Result updateMail(@RequestParam int id, @RequestParam String email){
        return this.userService.updateMail(id, email);
    }

    @PostMapping("/update-password")
    public Result updatePassword (@RequestParam int id, @RequestParam String oldPassword, @RequestParam String newPassword){
        return this.userService.updatePassword(id, oldPassword, newPassword);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)//sistemde bu türden bir hata olursa yukarıdaki responseEntity'i bad request ile sarmala //hataları yakala
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors= new HashMap<>();

        for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ErrorDataResult<>(validationErrors, "false");
    }
}
