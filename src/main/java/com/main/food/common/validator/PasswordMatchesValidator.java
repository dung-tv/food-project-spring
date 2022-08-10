package com.main.food.common.validator;

import com.main.food.modules.admin.dto.request.AdminReqDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final AdminReqDto user = (AdminReqDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }

}