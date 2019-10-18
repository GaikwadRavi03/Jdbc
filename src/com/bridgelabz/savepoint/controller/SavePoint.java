package com.bridgelabz.savepoint.controller;

import java.sql.SQLException;

import com.bridgelabz.savepoint.services.SavePointTransaction;

public class SavePoint {
	public static void main(String[] args) {
		SavePointTransaction spt = new SavePointTransaction(); // Create object of SavePointTransaction class
		try {
			spt.transcation(); // Method Call for Transaction.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
