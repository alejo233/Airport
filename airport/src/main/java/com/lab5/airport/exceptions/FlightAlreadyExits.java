package com.lab5.airport.exceptions;

import javax.swing.JOptionPane;

public class FlightAlreadyExits extends Exception {

	/*
	 * 
	 * */
	public FlightAlreadyExits(int id) {
		JOptionPane.showMessageDialog(null, "El vuelo "+ id+"ya se encuentra registrado");
	}

}
