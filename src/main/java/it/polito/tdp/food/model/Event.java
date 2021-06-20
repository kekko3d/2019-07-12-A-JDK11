package it.polito.tdp.food.model;

public class Event {

	private Integer macchinario;
	private boolean busy;
	private Integer tim;
	
	public Event(Integer macchinario, boolean libero, Integer tim) {
		super();
		this.macchinario = macchinario;
		this.busy = libero;
		this.tim = tim;
	}
	
	
	public Integer getMacchinario() {
		return macchinario;
	}
	public void setMacchinario(Integer macchinario) {
		this.macchinario = macchinario;
	}
	public boolean isLibero() {
		return busy;
	}
	public void setLibero(boolean libero) {
		this.busy = libero;
	}
	public Integer getTim() {
		return tim;
	}
	public void setTim(Integer tim) {
		this.tim = tim;
	}


	@Override
	public String toString() {
		return "Event [macchinario=" + macchinario + ", occupato=" + busy + ", tim=" + tim + "]";
	}
	
	
	
		
	
}
