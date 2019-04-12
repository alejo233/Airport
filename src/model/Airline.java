package model;

import java.util.ArrayList;
import java.util.List;

public class Airline {
	
	private String name;
	
	private Flight[]flight;
	
	public Airline(String n, Flight[]fg) {
		flight=fg;		
		name=n;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Flight[] getFlight() {
		return flight;
	}

	public void setFlight(Flight[]flight) {
		this.flight = flight;
	}
	
	

}
