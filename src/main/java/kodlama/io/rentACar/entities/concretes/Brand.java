package kodlama.io.rentACar.entities.concretes;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="brand")
@Entity
@Data
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//ID'nin bir bir artması icin
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Override
	public String toString()
	{
		return "%s-%s".formatted(this.id,this.name);
	}
	public Brand() {}
	public Brand(int id,String name) {this.id=id;this.name=name;}
	
	public void setId(int id) {this.id=id;}
	public void setName(String name) {this.name=name;}
	public int getId() {return id;}
	public String getName() {return name;}
	
	@OneToMany(mappedBy = "brand")//BrandId Diğer tarafta fazla olabilir.
	List<Model> models;
	
	}

