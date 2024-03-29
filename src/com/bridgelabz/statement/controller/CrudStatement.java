package com.bridgelabz.statement.controller;

import java.util.Scanner;

import com.bridgelabz.statement.model.Users;
import com.bridgelabz.statement.services.ImplUserLogin;

public class CrudStatement {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ImplUserLogin userLogin = new ImplUserLogin();// create object of ImplUserLogin class

		try {
			Scanner sc = new Scanner(System.in);
			int choice = 0;
			do {
				System.out.println("1.Insert user \n2.Update user\n3.Read user\n4.Delete user\n5.Exit");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					Users user = new Users();
					System.out.println("Enter user id");
					user.setUser_id(sc.nextInt());
					System.out.println("Enter user name");
					user.setUsername(sc.next());
					System.out.println("Enter user gamil");
					user.setGmail(sc.next());
					System.out.println("Enter user password");
					user.setPassword(sc.next());

					userLogin.insertIntoUser(user);
					System.out.println("User added successfully");
					break;

				case 2:
					userLogin.readFromUser();
					Users userUpdate = new Users();
					System.out.println("enter user id you want to update");
					int id = sc.nextInt();
					userLogin.updateIntoUser(id, userUpdate);
					break;

				case 3:
					userLogin.readFromUser();
					break;

				case 4:
					userLogin.readFromUser();
					System.out.println("Enter user_id you want to delete");
					int id1 = sc.nextInt();
					userLogin.deletefromUser(id1);
					userLogin.readFromUser();
					System.out.println("User deleted successfully");
					break;

				case 5:
					System.out.println("Exit");
					break;

				default:
					System.out.println("please Enter valid choice");
					break;
				}
			} while (choice != 5);
		} catch (Exception e) {
			System.out.println("invalid choice");
		}
	}
}
