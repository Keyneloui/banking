package com.revature;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerDAO {

	public static void main(String[] args) {
		 try {
			Visit.TestVisit();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	
		// TODO Auto-generated method stub
		try {
			returnBack();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void returnBack() throws SQLException {
		Scanner scn2 = new Scanner(System.in);
		System.out.println("Press 1 to Continue\nPress 2 to Sign out");
		int ch = scn2.nextInt();

		if (ch == 1) {
			System.out.println("Your Preferences:" + ch);

			TestFunction.function();
		} else {
			System.out.println("End");
		}

		
	}

}
