/**
 * https://www.code4copy.com/java/validate-uuid-string-java/
 * https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
 */

package up.deconto.tf1.delivery.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class IsUUIDValidator implements ConstraintValidator<IsUUID, String> {
	
	private final static Pattern UUID_REGEX_PATTERN = Pattern.compile("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");
	 
	@Override
	public void initialize(IsUUID constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
	        return false;
	    }
	    return UUID_REGEX_PATTERN.matcher(value).matches();
	}
}
