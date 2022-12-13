package comp.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//2.	User is able to register first then buy the product. 

public class UserRegistration1 {
	PreparedStatement prs=null;
	Connection con=null;
	
	public  void userInput( String username, String passcode ) {
		UserRegisterConnection urc=new UserRegisterConnection();
		try {
			
			 con= urc.connectionRegister();//connection built up
			 prs=con.prepareStatement("insert into UserDetails(User_id,User_passcode) values(?,?)");
			 prs.setString(1,username );
			 prs.setString(2, passcode);
			int i=prs.executeUpdate();
			// ResultSet rs=prs.executeQuery();
			 System.out.println("Record Inserted successfully" +i);
			 System.out.println();
			 
			
		}
		catch (Exception e) {
						e.printStackTrace();
		}
		
		
	}
	
	public void checkSwitch() {//method 2
		System.out.println("Enter 1 for login");
		System.out.println("Enter 2 for registration");
		System.out.println("Enter 3 for Shop_Admin");
		Scanner scan=new Scanner(System.in);
		int choice=scan.nextInt();
		//int choice;
		switch(choice){
		case 1:{
			UserRegistration1 us1=new UserRegistration1();
			us1.user();
			
			break;
		}
		case 2:{
			Scanner scan1=new Scanner(System.in);
			System.out.println("Enter your first name");
			String fName=scan1.next();
			System.out.println("Enter your last name");
			String lName=scan1.next();
			System.out.println("Enter your E-main ");
			String Email=scan1.next();
			System.out.println("Enter your Mobile Number");
			String Number=scan1.next();
			break;
		}
		case 3:{
			System.out.println("Shop details are :");
		
			UserRegistration1 ur=new UserRegistration1();
			ur.shopDetails();
			break;
		}
			
			
		}
	}
	
	
	
	
	public void shopDetails() {
		PreparedStatement prs=null;
		Connection con=null;
		UserRegisterConnection urc=new UserRegisterConnection();
		try {
			for(int i=1;i<=10;i++) {
			Scanner scan =new Scanner(System.in);
			System.out.println("Enter the product id to check the details");
			int id=scan.nextInt();
			con=urc.connectionRegister();
			prs=con.prepareStatement("select * from Product where pro_id="+id);
			ResultSet rs=prs.executeQuery();
			System.out.println("AVAILABLE PRODUCT QUANTITY BY PRODUCT ID :");
			
			while(rs.next()) {
				
				System.out.println("\nProduct_Name :"+rs.getString(4));
				System.out.println("Product_Quantity :"+rs.getString(5));
			}
			
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
		//public static void main(String[] args) {
			
		public void user() {
			
				 
		
		
		Scanner scan=new Scanner(System.in);
		//System.out.println("Welcome");
		for(int a=1;a<=1;a++) {
			
			
		System.out.println("Enter the username");
		String username=scan.next();
		
		
		System.out.println("Enter the passcode");
		String passcode=scan.next();
		//us1.userInput(username, passcode);
		
		}
		
		}
		
	
	
	
}


