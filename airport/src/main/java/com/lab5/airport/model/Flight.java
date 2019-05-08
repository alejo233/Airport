package com.lab5.airport.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lab5.airport.exceptions.FlightAlreadyExits;

/**
 * @author ASUS
 *
 */
public class Flight implements Comparable<Flight> {
	
	/*
	 * Number of the flight
	 * */
	private int id;
		
	/*
	 * Format for the data
	 * */
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss aa");

	/*
	 * Date of the flight
	 * */
	private Date date;
	
	/*
	 * Name of the destination city 
	 * */
	private String city;
	
	/*
	 * Name of the airline
	 * */
	private String airline;
	
	/*
	 * Number of gate
	 * */
	private int gate;
	
	private Flight next;
	
	private Flight prev;
	
	
	public Flight(int id, Date date, String city, String airline, int gate) {
		this.id = id;
		this. date = date;
		this.city = city;
		this.airline = airline;
		this.gate = gate;
	}
	
	public void add(Flight flight) throws FlightAlreadyExits {
		if(compareTo(flight) == 0) {
			throw new FlightAlreadyExits(flight.getId());
		}
		if (compareTo(flight) > 0) {
			if(prev == null) {
				prev = flight;
			}
			else {
				prev.add(flight);
			}
		} else {
			if(next == null) {
				next = flight;
			}
			else {
				next.add(flight);
			}
		}
	}
	
	public Flight search(int id) {
		if(Integer.compare(this.id, id) == 0) {
			return this;
		}
		else if (Integer.compare(this.id, id) > 0){
			return prev == null ? null: prev.search(id);
		}else {
			return next == null ? null: next.search(id);
		}
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	}


	public int getGate() {
		return gate;
	}


	public void setGate(int gate) {
		this.gate = gate;
	}


	public Flight getNext() {
		return next;
	}


	public void setNext(Flight next) {
		this.next = next;
	}


	public Flight getPrev() {
		return prev;
	}

	public String getDateFormated() {
		return dateFormat.format(date);
	}

	public void setPrev(Flight prev) {
		this.prev = prev;
	}

	public int compareTo(Flight o) {
		return date.compareTo(o.getDate());
	}
	
}
