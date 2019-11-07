
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.ConnectionUtil;
import com.revature.CustomerDAO;

public class TestFund {
	static Connection con = ConnectionUtil.getConnection();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			fundtransfer();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void fundtransfer() throws SQLException {
		// TODO Auto-generated method stub
		int FromAccountNo = 1234567;
		int toAccountNo = 4563728;
		int amount = 5000;
		int available_balance = 20000;
		System.out.println("Welcome to Canara Bank");
		System.out.println("Enter AccountNo:" + FromAccountNo);
		System.out.println("Available balance:" + available_balance);
		System.out.println("Enter the AccountNo to which you hve to transfer the money:" + toAccountNo);
		System.out.println("Enter the amount" + amount);
if (amount <= available_balance) {
			available_balance = available_balance - amount;
			System.out.println("Transaction Success");
			System.out.println("Available Money:" + available_balance);
			String sql = "insert into Fund_transfer(id,FromAccountNo,toAccountNo,amount,available_balance) values ( ?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
		    int id = 0;
			pst.setInt(1, id);
			pst.setInt(2, FromAccountNo);
			pst.setInt(3, toAccountNo);
			pst.setInt(4, amount);
			pst.setLong(5, available_balance);

			int rows = pst.executeUpdate();
			System.out.println("No of rows inserted:" + rows);

			CustomerDAO.returnBack();
		} else {
			System.out.println("Invalid Denominations");
		}

	}

}
