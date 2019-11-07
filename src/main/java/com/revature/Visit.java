

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.ConnectionUtil;

public class Visit {
	static Connection con = ConnectionUtil.getConnection();

	public static void main(String[] args) throws SQLException {
		TestVisit();
	}

	public static void TestVisit() throws SQLException {

		Scanner scn = new Scanner(System.in);
		System.out.println("Welcome to Canara Bank");

		System.out.println("To Login press 1");
		System.out.println("To Register press 2");
		int num = scn.nextInt();
		if (num == 1) {

			System.out.println("Login:");

			Scanner scn1 = new Scanner(System.in);
			System.out.println("Username:");
			String str = scn1.next();
			System.out.println("UserName:" + str);
			System.out.println("password:");
			Scanner scn2 = new Scanner(System.in);
			String str1 = scn2.next();
			System.out.println("Password:" + str1);

			String sql1 = "select id,username,password from login";
			PreparedStatement pst1 = con.prepareStatement(sql1);
			ResultSet rs = pst1.executeQuery();
			while (rs.next()) {

				String username = rs.getString("username");
				String password = rs.getString("password");

				System.out.println(username + "-" + password);
				System.out.println("Login Success");
				info();
				TestFunction.function();

			}
		} else if (num == 2) {
			System.out.println("Account Creation");
			Scanner scna = new Scanner(System.in);
			System.out.println("name");
			String name = scna.next();
			System.out.println("Name:" + name);
			Scanner scnb = new Scanner(System.in);
			System.out.println("mobile_no");
			int mobile_no = scnb.nextInt();
			System.out.println("Mobile_no:" + mobile_no);
			Scanner scnc = new Scanner(System.in);
			System.out.println("place");
			String place = scnc.next();
			System.out.println("Place:" + place);
			Scanner scnd = new Scanner(System.in);
			System.out.println("aadhar_card_no");
			int aadhar_card_no = scnd.nextInt();
			System.out.println("Aadhar_card_no:" + aadhar_card_no);
			Scanner scne = new Scanner(System.in);
			System.out.println("set_password");
			String set_password = scne.next();
			System.out.println("set_password:" + set_password);
				System.out.println("Registration success");
				String sql = "insert into create_account(name,mobile_no,place,aadhar_card_no,set_password) values ( ?,?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, name);
				pst.setInt(2, mobile_no);
				pst.setString(3, place);
				pst.setLong(4, aadhar_card_no);
				pst.setString(5, set_password);
				

				int rows = pst.executeUpdate();
				System.out.println("No of rows inserted:" + rows);
				/*String sql1 = "select name,account_number,customer_id,account_balance,active from create_account";
				PreparedStatement pst1 = con.prepareStatement(sql1);
				ResultSet rs = pst1.executeQuery();
				while (rs.next()) {
					String name1 = rs.getString("name");
					int account_number = rs.getInt("account_number");
					int customer_id = rs.getInt("customer_id");
					int account_balance = rs.getInt("account_balance");
					boolean active = rs.getBoolean("active");

					System.out.println(name1 + "-" + account_number + "-" + customer_id + "-" + account_balance + "-" + active);
				}*/

				TestFunction.function();
		}
			
			// Connection con1 = ConnectionUtil.getConnection();

		}
	

	public static void info() throws SQLException {
		// Connection con = ConnectionUtil.getConnection();

		String sql1 = "select name,account_number,customer_id,account_balance,active from account_info";
		PreparedStatement pst1 = con.prepareStatement(sql1);
		ResultSet rs = pst1.executeQuery();
		while (rs.next()) {
			String name = rs.getString("name");
			int account_number = rs.getInt("account_number");
			int customer_id = rs.getInt("customer_id");
			int account_balance = rs.getInt("account_balance");
			boolean active = rs.getBoolean("active");

			System.out.println(name + "-" + account_number + "-" + customer_id + "-" + account_balance + "-" + active);

		}
		// TODO Auto-generated method stub

	}
}
