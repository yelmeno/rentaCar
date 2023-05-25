package coding.io.rentaCar.business.rules;

import org.springframework.stereotype.Service;

import coding.io.rentaCar.core.utilities.exceptions.BusinessException;
import coding.io.rentaCar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
	
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand name already exist");//Java exception types
		}
		
	}

}
