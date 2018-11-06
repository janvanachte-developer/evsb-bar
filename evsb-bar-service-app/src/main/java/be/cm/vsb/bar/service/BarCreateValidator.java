package be.cm.vsb.bar.service;

import be.cm.vsb.bar.Bar;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreateBarValidator")
public class BarCreateValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Bar.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        System.out.println("beforeCreateBarValidator");

        Bar item = (Bar) object;

        if (isNameEmptyOrLessThan10Long(item)) {
            errors.rejectValue("name", "name.empty");
        }
    }

    private boolean isNameEmptyOrLessThan10Long(Bar item) {
        return StringUtils.isEmpty(item.getName()) || item.getName().length() < 10;
    }
}
