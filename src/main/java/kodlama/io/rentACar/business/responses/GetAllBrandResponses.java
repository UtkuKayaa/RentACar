package kodlama.io.rentACar.business.responses;

import lombok.Data;



@Data
public class GetAllBrandResponses {
	private int id;
	private String name;
	
	
	public GetAllBrandResponses() {
		
	}
	public GetAllBrandResponses(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
	public void setId(int id) {this.id=id;}
	public int getId() {return id;}
	public void setName(String name) {this.name=name;}
	public String getName() {return name;}
}
