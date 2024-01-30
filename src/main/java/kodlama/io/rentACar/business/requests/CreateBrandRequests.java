package kodlama.io.rentACar.business.requests;

import lombok.Data;

@Data
public class CreateBrandRequests {
	private String name;
	public CreateBrandRequests() {}
	public CreateBrandRequests(String name) {this.setName(name);}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
