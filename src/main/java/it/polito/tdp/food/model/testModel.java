package it.polito.tdp.food.model;

public class testModel {

	public static void main(String[] args) {

		Model md = new Model();
		md.creaGrafo(9);
		md.Init(9, new Food(23559, "Ground beef (95% lean)"));

	}

}
