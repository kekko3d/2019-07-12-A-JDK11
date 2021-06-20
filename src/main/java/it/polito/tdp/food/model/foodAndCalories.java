package it.polito.tdp.food.model;

public class foodAndCalories {

	
	private Food food;
	private double calories;
	
	public foodAndCalories(Food food, double calories) {
		this.food = food;
		this.calories = calories;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	@Override
	public String toString() {
		return "food: " + food + ", calories: " + (int) calories;
	}
	
	
	
	
	
}
