package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.model.Model;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponses;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetAllModelsResponses;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperManager;

@RestController
@RequestMapping("/api/models")
public class ModelController {
	private ModelService modelService;
	private ModelMapperManager modelMapperManager;
	
	@Autowired
	public ModelController(ModelService modelService,ModelMapperManager modelMapperManager){
		this.modelService = modelService;
		this.modelMapperManager=modelMapperManager;
	}
	
	@GetMapping("/api/findAll")
    public List<GetAllModelsResponse> findAll() {
        return modelService.findAll();
    }
	
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(CreateModelRequest createModelRequest)
	{
		
		modelService.add(createModelRequest);
	}
	
	
}
