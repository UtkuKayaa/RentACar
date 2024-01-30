package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cars")
public class Car {
	@Id//Primary Key Yapmak için
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="plate",unique = true)
	private String plate;
	
	
	@Column(name="dailyPrice")
	private double dailyprice;
	
	@Column(name="modelYear")
	private int modelYear;
	
	@Column(name="status") // 1-Available 2-Rented 3-Bakimda
	private int state;
	
	@ManyToOne
	@JoinColumn(name = "modelId")
	private Model model;
	

	public Car() {
		
	}

	public Car(int id, String plate, double dailyprice, int modelYear, int state, Model model) {
		super();
		this.id = id;
		this.plate = plate;
		this.dailyprice = dailyprice;
		this.modelYear = modelYear;
		this.state = state;
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public double getDailyprice() {
		return dailyprice;
	}

	public void setDailyprice(double dailyprice) {
		this.dailyprice = dailyprice;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	

}
