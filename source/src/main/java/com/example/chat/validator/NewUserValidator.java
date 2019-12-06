package com.example.chat.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.chat.entity.Users;
import com.example.chat.repository.UserRepository;

@Component
public class NewUserValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Users.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Users newUser = (Users) target;
        if (userRepository.existsById(newUser.getEmail())) {
            errors.rejectValue("username", "new.account.username.already.exists");
        }
    }
}
