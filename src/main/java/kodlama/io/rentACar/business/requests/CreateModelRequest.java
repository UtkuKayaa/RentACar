package kodlama.io.rentACar.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateModelRequest {
	@NotNull
	@NotBlank
	private int brandId;
	@NotNull
	@NotBlank
	@Size(min = 3,max = 20)
	private String name;
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CreateModelRequest(@NotNull @NotBlank int brandId, @NotNull @NotBlank @Size(min = 3, max = 20) String name) {
		super();
		this.brandId = brandId;
		this.name = name;
	}
	
	

}
