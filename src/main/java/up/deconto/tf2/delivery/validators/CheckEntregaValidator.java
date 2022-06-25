package up.deconto.tf2.delivery.validators;

import java.util.UUID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import up.deconto.tf2.delivery.dto.EntregaDTO;
import up.deconto.tf2.delivery.services.EntregaService;
import up.deconto.tf2.delivery.utils.UUIDUtil;

public class CheckEntregaValidator implements ConstraintValidator<CheckEntrega, String> {
	
	@Autowired
	EntregaService entregaService;
	
	@Override
	public void initialize(CheckEntrega constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
	        return true;
	    }
		
		if(UUIDUtil.isUUID(value) == true) {
			UUID uuid = UUIDUtil.str2uuid(value);
			
			EntregaDTO entrega = entregaService.findById(uuid);
			
			if(entrega != null) {
				return true;
			}
		}
		
	    return false;
	}
}
