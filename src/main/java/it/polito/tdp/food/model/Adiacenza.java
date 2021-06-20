package it.polito.tdp.food.model;

public class Adiacenza {

	private Integer f1; 
	private Integer f2; 
	private double peso;
	
	public Adiacenza(Integer f1, Integer f2, double peso) {
		super();
		this.f1 = f1;
		this.f2 = f2;
		this.peso = peso;
	}
	public Integer getF1() {
		return f1;
	}
	public void setF1(Integer f1) {
		this.f1 = f1;
	}
	public Integer getF2() {
		return f2;
	}
	public void setF2(Integer f2) {
		this.f2 = f2;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	@Override
	public String toString() {
		return "Adiacenza [f1=" + f1 + ", f2=" + f2 + ", peso=" + peso + "]";
	}
	
	
	
}