package com.bridgelabz.callable.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.callable.services.UserLogin;
import com.bridgelabz.callable.model.Users;
import com.bridgelabz.callable.repository.JdbcConnectivity;
import com.mysql.jdbc.Connection;

public class ImplUserLogin implements UserLogin {

	static Connection con = (Connection) JdbcConnectivity.getConnection();	// Method call for DB connection
	static java.sql.CallableStatement cs = null;	// Create object of CallableStatement

	/**
	 * Purpose : Insert new user in DataBase.
	 */
	@Override
	public int insertIntoUser(Users user) {
		// TODO Auto-generated method stub
		try {
			cs = con.prepareCall("call insertUser(?,?,?,?)");
			cs.setInt(1, user.getUser_id());
			cs.setString(2, (user.getUsername()));
			cs.setString(3, (user.getGmail()));
			cs.setString(4, (user.getPassword()));
			return cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Purpose : Update the user data from database and stored in database.
	 */
	@Override
	public int updateIntoUser(int id, Users user) {
		// TODO Auto-generated method stub
		try {
			System.out.println("1.name\n2.gmail\n3.password\n4.exit");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int ch1 = sc.nextInt();
			switch (ch1) {

			case 1:
				System.out.println("enter new user name");
				String uname = sc.next();
				user.setUsername(uname);
				try {
					cs = con.prepareCall("call updateName(?,?)");
					cs.setInt(1, id);
					cs.setString(2, user.getUsername());
					System.out.println("User name updated");
					return cs.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 2:
				System.out.println("enter new gmail");
				String gmail = sc.next();
				user.setGmail(gmail);
				try {
					cs = con.prepareCall("call updateGmail(?,?)");
					cs.setInt(1, id);
					cs.setString(2, user.getGmail());
					System.out.println("User mail updated");
					return cs.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 3:
				System.out.println("enter new password");
				String pass = sc.next();
				user.setPassword(pass);
				try {
					cs = con.prepareCall("call updatePassword(?,?)");
					cs.setInt(1, id);
					cs.setString(2, user.getPassword());
					System.out.println("User password updated");
					return cs.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 4:
				System.out.println("Exit");
				break;

			default:
				System.out.println("Enter Invalid input");
				break;
			}
		} catch (Exception e) {
			System.out.println("Invalid choice");
		}
		return 0;
	}

	/**
	 * Purpose : print the user all data which stored in database.
	 */
	@Override
	// TODO Auto-generated method stub
	public void readFromUser() {
		try {

			cs = con.prepareCall("call readUser");
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				System.out.println("user_id: " + rs.getInt(1) + " username: " + rs.getString(2) + " gmail: "
						+ rs.getString(3) + " password: " + rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Purpose : Delete the user from DataBase.
	 */
	public int deletefromUser(int id) throws SQLException {
		// TODO Auto-generated method stub
		cs = con.prepareCall("call deleteUser(?)");
		cs.setInt(1, id);
		return cs.executeUpdate();
	}
}
