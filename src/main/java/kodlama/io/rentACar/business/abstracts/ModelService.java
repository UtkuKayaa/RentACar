package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> findAll();
	
	public void add(CreateModelRequest createModelRequest);
	
	
}
