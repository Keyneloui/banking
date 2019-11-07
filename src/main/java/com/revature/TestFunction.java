

import java.sql.SQLException;
import java.util.Scanner;

public class TestFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			function();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void function() throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Select your preference");
		System.out.println(
				"Press 1 to Deposit\nPress 2 to Withdrawal\nPress 3 to Fund Transfer\nPress 4 to check balance");
		Scanner scn1 = new Scanner(System.in);

		int num1 = scn1.nextInt();
		System.out.println("No:" + num1);
		switch (num1) {
		case 1:
			System.out.println("Deposit");
			TestDeposit.Deposition();
			break;
		case 2:
			System.out.println("Withdrawal");
			TestWithdrawal.Witthdrawal();
			break;
		case 3:
			System.out.println("Fund transfer");
			TestFund.fundtransfer();
			break;
		case 4:
			System.out.println("Check Balance");
			break;
		case 5:
			System.out.println("Deactivate");
		default:
			System.out.println("Invalid Denominations");
		}

	}

}
