package com.lab5.airport.model;


import java.util.Date;
import java.util.Random;

import com.lab5.airport.exceptions.FlightAlreadyExits;

public class Airport {
	
	/*
	 * Number of flights
	 * */
	private int flightNumber;
	
	/*
	 * The first fligth (root)
	 * */
	private Flight flight;
	
		
	public Airport() {
		flight = null;
		flightNumber = 0;
	}
	
	public void addFlight(Flight flight) throws FlightAlreadyExits {
		if (this.flight == null) {
			this.flight = flight;
		}else {
			this.flight.add(flight);
		}
		flightNumber++;
	}
	
	public void generateData(int cant) {
		
		String[] cities = new String[] {"Cali", "Bogotá", "Buenos Aires", "Nueva York", "Caracas"};
		String[] airlines = new String[] {"Avianca", "Viva Colombia", "Latam"};
		Random random = new Random();
		
		for (int i = 0; i < cant; i++) {
			int id = i;
			int month = random.nextInt(12);
			int day = random.nextInt(31)+1; 
			int hrs = random.nextInt(23);
			int min = random.nextInt(59);
			@SuppressWarnings("deprecation")
			Date date = new Date(119, month, day, hrs, min);
			String city = cities[random.nextInt(cities.length)];
			String airline = airlines[random.nextInt(airlines.length)];
			int gate = random.nextInt(12)+1;
			
			Flight temp = new Flight(id, date, city, airline, gate);
			
			try {
				addFlight(temp);
			} catch (FlightAlreadyExits e) {
				e.printStackTrace();
			}
		}
	}
	
	public void bubbleSortDate() {
		if (!isEmpty()) {
		       boolean cambio;
		       do {
		           Flight actual = flight;
		           Flight anterior = null;
		           Flight siguiente = flight.getNext();
		           cambio = false;
		           while ( siguiente != null ) {
		               if (actual.getDate().compareTo(siguiente.getDate())>0) {
		                   cambio = true;
		                   if ( anterior != null ) {
		                       Flight sig = siguiente.getNext();
		                       anterior.setNext(siguiente);
		                       siguiente.setNext(actual);
		                       actual.setNext(sig);
		                   } else {
		                       Flight sig = siguiente.getNext();
		                       flight = siguiente;
		                       siguiente.setNext(actual);
		                       actual.setNext(sig);
		                   }
		                   anterior = siguiente;
		                   siguiente = actual.getNext();
		               } else { 
		                   anterior = actual;
		                   actual = siguiente;
		                   siguiente = siguiente.getNext();
		               }
		           } 
		       } while( cambio );
		   }
	}
	
	public Flight searchFlightId(int id) {
		return flight == null ? null: flight.search(id);
	}
	
	public boolean isEmpty() {
		return flight == null;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public Flight getFlight() {
		return flight;
	}
	
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
}
