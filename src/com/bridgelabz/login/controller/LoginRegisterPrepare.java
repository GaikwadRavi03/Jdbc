package com.bridgelabz.login.controller;

import java.sql.SQLException;
import java.util.Scanner;
import com.bridgelabz.login.model.Users;
import com.bridgelabz.login.services.ImplUserLogin;

public class LoginRegisterPrepare {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException {

		ImplUserLogin userLogin = new ImplUserLogin();
		Users user = new Users();
		Scanner sc = new Scanner(System.in);

		try {
			boolean flag = true;
			while (flag) {
				System.out.println("1.Login User\n2.Register User\n3.Exit");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter User id:");
					int id = sc.nextInt();
					System.out.println("Enter User name:");
					String name = sc.next();
					user = userLogin.checkUser(id, name);		//Fun call for Search user in Database
					if (user != null) {
						if (user.getUser_id() == id) {
							System.out.println(user.getUser_id());
							System.out.println(user.getUsername());
							System.out.println(user.getGmail());
							System.out.println(user.getPassword());
							System.out.println("Login Successfully");
						} else {
							System.out.println("User not found");
						}
					}
					break;

				case 2:
					System.out.println("Enter the user details to Register");
					System.out.println("Enter user id");
					user.setUser_id(sc.nextInt());
					System.out.println("Enter user name");
					user.setUsername(sc.next());
					System.out.println("Enter user gamil");
					user.setGmail(sc.next());
					System.out.println("Enter user password");
					user.setPassword(sc.next());
					userLogin.insertUser(user);		//Fun call for Add new user in Database
					System.out.println("User added successfully");
					break;

				case 3:
					System.out.println("Exit");
					flag = false;
					break;

				default:
					System.out.println("Please Enter valid input");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid Input");
		}
	}
}
