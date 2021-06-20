package it.polito.tdp.food.model;

public class Machine {
	private int id;
	private boolean busy;
	private Integer time;
	private Food food;
	
	public Machine(int id, boolean busy, Food food) {
		this.id = id;
		this.busy = busy;
		this.time = 0;
		this.food = food;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isBusy() {
		return busy;
	}
	public void setBusy(boolean busy) {
		this.busy = busy;
	}
	
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getTime() {
		return time;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	@Override
	public String toString() {
		return "Machine [id=" + id + ", busy=" + busy + ", time=" + time + ", food=" + food + "]";
	}
	
	
	
}
