

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.ConnectionUtil;
import com.revature.CustomerDAO;

public class TestDeposit {
	static Connection con = ConnectionUtil.getConnection();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Deposition();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void Deposition() throws SQLException {
		int id=0;
		int amount = 10000;
		int available_balance = 15000;
		int account_number = 1234567;
		System.out.println("Welcome to Canara Bank");
			System.out.println("Enter AccountNo:" + account_number);
			System.out.println("Amount of money to be deposited" + amount);

			available_balance = amount + available_balance;
			System.out.println("Deposit Success");
			System.out.println("Available_balance:" + available_balance);
			String sql = "insert into Deposit(id,account_number,amount,available_balance) values ( ?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setInt(2, account_number);
			pst.setInt(3, amount);
			pst.setLong(4, available_balance);
			

			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted:" + rows);

			CustomerDAO.returnBack();
		

		}
		// TODO Auto-generated method stub

	}



