package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequests;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponses;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;

@RestController //Annotation
@RequestMapping("/api/brands") 
public class BrandsController {
	@Autowired
	private BrandService brandService;
	
	
	public BrandsController() {}
	public BrandsController(BrandService brandService){this.brandService=brandService;}
	
	@GetMapping("{id}")//{variable}
	public  GetByIdBrandResponse getById(@PathVariable int id)
	{
		return brandService.getById(id);
	}
	
	@PutMapping
	public void update(UpdateBrandRequest updateBrandRequest)
	{
		this.brandService.update(updateBrandRequest);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id)
	{
		this.brandService.delete(id);
	}
	
	 @GetMapping("/api/findAll")
	    public List<GetAllBrandResponses> findAll() {
	        return brandService.findAll();
	    }
	  
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(CreateBrandRequests createBrandRequests)
	{
	
		this.brandService.add(createBrandRequests);
	}
	
}
