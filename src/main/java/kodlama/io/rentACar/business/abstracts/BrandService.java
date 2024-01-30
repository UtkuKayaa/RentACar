package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.requests.CreateBrandRequests;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponses;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;


@Service
public interface BrandService {
	List<GetAllBrandResponses> findAll();
	
	public void add(CreateBrandRequests createBrandRequests);
	public void update(UpdateBrandRequest updateBrandRequest);
	public void delete(int id);
	public GetByIdBrandResponse getById(int id);
	
	
}
