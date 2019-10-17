package com.bridgelabz.prepare.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.bridgelabz.prepare.model.Users;
import com.bridgelabz.prepare.repository.JdbcConnectivity;
import com.mysql.jdbc.Connection;

public class ImplUserLogin implements UserLogin {

	static Connection con = (Connection) JdbcConnectivity.getConnection();	// Method call for DB connection
	static PreparedStatement pstmt = null;		// Create object of PrepareStatement

	/**
	 * Purpose : Insert new user in DataBase.
	 */
	@Override
	public int insertIntoUser(Users user) throws SQLException {
		// TODO Auto-generated method stub
		String query = "INSERT INTO Users VALUES(?,?,?,?)";

		pstmt = con.prepareStatement(query);

		pstmt.setInt(1, user.getUser_id());
		pstmt.setString(2, (user.getUsername()));
		pstmt.setString(3, (user.getGmail()));
		pstmt.setString(4, (user.getPassword()));

		return pstmt.executeUpdate();
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
				String name = sc.next();
				String query = "UPDATE Users SET  username= '" + name + "' WHERE user_id= " + id;
				try {
					pstmt = con.prepareStatement(query);
					System.out.println("user name update");
					return pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 2:
				System.out.println("enter new gmail");
				String gmail = sc.next();
				String query1 = "UPDATE Users SET  gmail= '" + gmail + "' WHERE user_id= " + id;
				try {
					pstmt = con.prepareStatement(query1);
					System.out.println("user mail update");
					return pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 3:
				System.out.println("enter new password");
				String pass = sc.next();
				String query2 = "UPDATE Users SET  password= '" + pass + "' WHERE user_id= " + id;
				try {
					pstmt = con.prepareStatement(query2);
					System.out.println("user password update");
					return pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case 4:
				System.out.println("Exit");
				break;

			default:
				System.out.println("PLease enter valid input");
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
	public void readFromUser() {
		// TODO Auto-generated method stub
		try {
			String query = "select * from Users";

			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
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
	public int deletefromUser(int id) {
		// TODO Auto-generated method stub
		try {
			String query = "delete from Users where user_id=" + id;

			pstmt = con.prepareStatement(query);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
