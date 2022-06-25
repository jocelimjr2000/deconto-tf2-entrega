package up.deconto.tf2.delivery.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import up.deconto.tf2.delivery.dto.EntregadorDTO;
import up.deconto.tf2.delivery.services.EntregadorService;

public class CheckEntregadorValidator implements ConstraintValidator<CheckEntregador, String> {
	
	@Autowired
	EntregadorService entregadorService;
	
	@Override
	public void initialize(CheckEntregador constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
	        return true;
	    }
		
		EntregadorDTO entregadorDTO = entregadorService.findById(value);
		
		if(entregadorDTO != null) {
			return true;
		}
		
	    return false;
	}
}
