package etc;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class UserEntryValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		if( ! StringUtils.hasLength(user.getUserId())) {
			errors.rejectValue("userId", "error.required.user");
		}
		if( ! StringUtils.hasLength(user.getPassword())) {
			errors.rejectValue("password", "error.required.user");
		}
		if( ! StringUtils.hasLength(user.getUserName())) {
			errors.rejectValue("userName", "error.required.user");
		}
		if( ! StringUtils.hasLength(user.getAddress())) {
			errors.rejectValue("address", "error.required.user");
		}
		if( ! StringUtils.hasLength(user.getEmail())) {
			errors.rejectValue("email", "error.required.user");
		}
		if( ! StringUtils.hasLength(user.getBirthday())) {
			errors.rejectValue("birthday", "error.required.user");
		}
		if( user.getBirthday().length() != 8 ) {
			errors.rejectValue("birthday", "typeMismatch.user");
			
		} //생년월일이 8자리가 아닌 경우
		if( errors.hasErrors()) {
			errors.reject("error.input.user");
		} //입력데이터 중 하나라도 문제가 있는 경우

	}

}
