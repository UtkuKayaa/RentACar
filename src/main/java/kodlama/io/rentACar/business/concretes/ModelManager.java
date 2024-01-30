package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMappersService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepistory;
import kodlama.io.rentACar.entities.concretes.Model;

@Service
public class ModelManager implements ModelService{
	
	
	private ModelMappersService modelMapperService;
	private ModelRepistory modelRepository;
	
	
	

	public ModelManager() {
		
	}




	@Autowired
	public ModelManager(ModelRepistory modelRepository,ModelMappersService modelMapperService) {
	
		this.modelRepository = modelRepository;
		this.modelMapperService =modelMapperService;
	}




	@Override
	public List<GetAllModelsResponse> findAll() {
		
		List<Model> models = modelRepository.findAll();
		List<GetAllModelsResponse> response = models.stream()
			    .map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
			    .collect(Collectors.toList());

		return response;
	}




	public void add(CreateModelRequest createModelRequest) {
		Model model =this.modelMapperService.forRequest().map(createModelRequest,Model.class);
		this.modelRepository.save(model);
				
		
	}

}
