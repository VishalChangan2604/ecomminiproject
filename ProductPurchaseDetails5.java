package comp.test;
//9.	Admin should able to check the particular user history for product purchase details
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductPurchaseDetails5 {
	
	
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement prs=null;
		UserRegisterConnection urc=new UserRegisterConnection();
		try {
			Scanner scan=new Scanner(System.in);
			System.out.println("Enter Customer name");
			String name=scan.next();
			con=urc.connectionRegister();
			prs=con.prepareStatement("select * from Product where"+name);
			ResultSet rs=prs.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
