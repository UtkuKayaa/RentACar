package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequests;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponses;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMappersService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMappersService modelMappersService;
    private BrandBusinessRules brandBusinessRules;
    @Autowired
    public BrandManager(BrandRepository brandRepository, ModelMappersService modelMappersService,BrandBusinessRules brandBusinessRules) {
        this.brandRepository = brandRepository;
        this.modelMappersService = modelMappersService;
        this.brandBusinessRules=brandBusinessRules;
    }

    @Override
    public List<GetAllBrandResponses> findAll() {
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandResponses> brandResponse = brands.stream().map(brand -> this.modelMappersService.forResponse().
                map(brand, GetAllBrandResponses.class)).collect(Collectors.toList());

        return brandResponse;
    }

    @Override
    public void add(CreateBrandRequests createBrandRequests) {
        Brand brand = this.modelMappersService.forRequest().map(createBrandRequests, Brand.class);
        
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequests.getName());
        
        this.brandRepository.save(brand);
        
    }
    
    public GetByIdBrandResponse getById(int id)
    {
    	Brand brand = this.brandRepository.findById(id).orElseThrow();
    	GetByIdBrandResponse response = this.modelMappersService.forResponse().map(brand, GetByIdBrandResponse.class);
    	return response;
    }
	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		 Brand brand = this.modelMappersService.forRequest().map(updateBrandRequest, Brand.class);
		 this.brandRepository.save(brand);
	}

	@Override
	public void delete(int id) {
		
	
		this.brandRepository.deleteById(id);;
	}

	
}