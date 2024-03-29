package kodlama.io.rentACar.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;

@Service
public class BrandBusinessRules {
	private BrandRepository brandRepository;
	
	@Autowired
	public BrandBusinessRules(BrandRepository brandRepository) {
		
		this.brandRepository = brandRepository;
	}


	public void checkIfBrandNameExists(String name)
	{
		
		if(this.brandRepository.existsByName(name)) {
			
			throw new BusinessException("Brand already exists");
		}
	
	}
}
