package comp.test;

import java.sql.Connection;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BuyProduct2 {
	
	
	static int total;
//	public static void main(String[] args) {
		
		public void product() {
		
		Connection con=null;
		PreparedStatement prs=null;
		 
		UserRegisterConnection urc=new UserRegisterConnection();
		try {
			con=urc.connectionRegister();
			 
			//prs=con.prepareStatement("select * from Product ");
			
			prs=con.prepareStatement("select * from Product");
			//SELECT * FROM student WHERE city = 'pune' ORDER BY salary;
			System.out.println("**********WELCOME***********\n");
			System.out.println(" ******HAPPY SHOPPING!********");
			System.out.println("CHECK THE PRODUCT LIST:");	
			ResultSet rs=prs.executeQuery();
			
			while(rs.next()) {
				
			System.out.println(rs.getInt(1));
			System.out.print(rs.getString(2));
			System.out.print(rs.getString(3));
			System.out.print(rs.getString(4));
			System.out.println(rs.getString(5));

			
			
			}
			System.err.println("\nPRODUCTS NAME ARE SORTED IN ASCENDING ORDER");
			prs=con.prepareStatement("select * from Product order by prod_name ");
			
			ResultSet rs1=prs.executeQuery();
			while(rs1.next()) {
								System.out.println(rs1.getString(4));
					}
							} catch (SQLException e) {
			
			e.printStackTrace();
		}
		/*BuyProduct2 bp=new BuyProduct2();
		bp.buyProduct();
		bp.table();*/
		
			}//main
	
	
	
	public void buyProduct() {
		Connection con1=null;
		PreparedStatement prs1=null;
		UserRegisterConnection urc1=new UserRegisterConnection();

		
		try {
			System.err.println("YOU CAN BUY MULTIPLE PRODUCTS:");
			for(int k=1;k<=3;k++) {
			System.err.println("\nENTER PRODUCT NAME TO BUY FROM LIST");//1
			Scanner scan =new Scanner(System.in);
			String name=scan.next();
			con1=urc1.connectionRegister();
			prs1=con1.prepareStatement("select * from Product where prod_name='"+name+"'");
			
			ResultSet rs1=prs1.executeQuery();
			while(rs1.next()) {
				System.out.println("Product name: "+rs1.getString(4));
				
				System.out.println("Product Price :"+rs1.getString(3));
			total=total+rs1.getInt(3);
			}
			
			}
			
			System.err.println("Total bill: " +total  +"\n");
			System.out.println("THANK YOU!");
			System.err.println("VISIT US AGAIN!");
						
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
			}
	
	
	//**********************************
	
	public void table() {
		Connection con1=null;
		PreparedStatement prs1=null;
		UserRegisterConnection urc1=new UserRegisterConnection();

		
		try {
			/*System.err.println("YOU CAN BUY MULTIPLE PRODUCTS:");
			for(int k=1;k<=3;k++) {
			System.err.println("\nENTER PRODUCT NAME TO BUY FROM LIST");//1
			Scanner scan =new Scanner(System.in);
			String name=scan.next();*/
			con1=urc1.connectionRegister();
			prs1=con1.prepareStatement("insert into productdetails where ");
			ResultSet rs1=prs1.executeQuery();
			while(rs1.next()) {
				System.out.println(rs1.getString(4));
				
				System.out.println(rs1.getString(3));
				System.out.println("Added to table");
			
			//}
			
			}
			
			
						
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
			}
	
	
}

