package validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.FloMemb;

public class MembentryValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return FloMemb.class.isAssignableFrom(clazz);
	} //검증의 대상이 되는 객체 설정

	public void validate(Object target, Errors errors) {
		FloMemb fmb =(FloMemb)target;
		if( ! StringUtils.hasLength(fmb.getMembId())) {
			errors.rejectValue("membId", "error.required");
		}
		if( ! StringUtils.hasLength(fmb.getMembPwd())) {
			errors.rejectValue("membPwd", "error.required");
		}
		if( ! StringUtils.hasLength(fmb.getMembName())) {
			errors.rejectValue("membName", "error.required");
		}
		if(errors.hasErrors()) {
			errors.reject("error.input.memb");
		}
	}

}
