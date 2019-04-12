package model;

import java.time.LocalDate;

public class Flight implements Comparable {
	
	public int date1;
	public String timeSchedule;
	public String flightNumber;
	public String destination;
	public String boardingGate; 
	public LocalDate date;
	
	public Flight(int d, String tS, String fN, String dest, String bG) {
		date1=d;
		timeSchedule=tS;
		flightNumber=fN;
		destination=dest;
		boardingGate=bG;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date1 = date;
	}

	public String getTimeSchedule() {
		return timeSchedule;
	}

	public void setTimeSchedule(String timeSchedule) {
		this.timeSchedule = timeSchedule;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	
	public int getDate1() {
		return date1;
	}

	public void setDate1(int date1) {
		this.date1 = date1;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getBoardingGate() {
		return boardingGate;
	}

	public void setBoardingGate(String boardingGate) {
		this.boardingGate = boardingGate;
	}

	@Override
	public int compareTo(Object flight2) {
		// TODO Auto-generated method stub
		Flight f= (Flight)flight2;
		
		return date.compareTo(f.getDate());
	}
	
	
	
}
