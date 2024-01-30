package kodlama.io.rentACar.business.responses;


import lombok.Data;

@Data
public class GetByIdBrandResponse {
	private int id;
	private String name;
	public GetByIdBrandResponse() {
		
	}
	public GetByIdBrandResponse(int id, String name) {
	
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
