

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.ConnectionUtil;
import com.revature.CustomerDAO;

public class TestWithdrawal {
	static Connection con = ConnectionUtil.getConnection();

	public static void main(String[] args) {
		//Connection con = ConnectionUtil.getConnection();
	 try {
		Witthdrawal();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
		}


	

	public static void Witthdrawal() throws SQLException {
		// TODO Auto-generated method stub
		int amount = 10000;
		int available_balance = 15000;
		int account_number = 1234567;
		int id=0;

		System.out.println("Welcome to Canara Bank");
		if (amount <= available_balance) {
			System.out.println("Enter account_number :" + account_number);
			System.out.println("Available balance:" + available_balance);
			available_balance = available_balance - amount;
			System.out.println("Withdrawal Success");
			System.out.println("Remaining amount:" + amount);
			String sql = "insert into withdrawal(id,account_number,amount,available_balance) values ( ?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setInt(2, account_number);
			pst.setInt(3, amount);
			pst.setLong(4, available_balance);
			

			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted:" + rows);


			CustomerDAO.returnBack();
		} else {
			System.out.println("Invalid Credentials");

		}
	}




	
}
