package it.polito.tdp.food.model;

public class Machine {
	private int id;
	private boolean busy;
	private Integer time;
	
	public Machine(int id, boolean busy) {
		this.id = id;
		this.busy = busy;
		this.time = 0;
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
	
	@Override
	public String toString() {
		return "Machine [id=" + id + ", busy=" + busy + ", time=" + time + "]";
	}
	
	
}
