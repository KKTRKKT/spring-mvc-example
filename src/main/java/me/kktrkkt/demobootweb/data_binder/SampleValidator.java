package me.kktrkkt.demobootweb.data_binder;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SampleValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Sample.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sample sample = (Sample) target;
        if(sample.getName().equals("admin")){
            errors.rejectValue("name", "wrongValue", "the value is not allowed");
        }
    }
}
