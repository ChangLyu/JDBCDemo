package jdbcDemo;
import java.sql.*;
public class Driver {

	public static void main(String[] args){
	
		// using SQL to insert,edit,delete information from a databse
		
		try{
			// 1.make a connection to database
			Connection myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping_cart","root","12345");
			
			//2.create a statement
			Statement myStmt= myConn.createStatement();
			
			//3. execute SQL statement :read all the information
			ResultSet myRs =myStmt.executeQuery("SELECT * FROM shopping_cart.customers");
			
			//4.show the result set
			while(myRs.next()){
				System.out.println(myRs.getInt("customer_ID")+","+myRs.getString("customer_name")+","+myRs.getInt("shopping_cart_ID"));
			}
			
			//3. execute SQL statement: insert into new information
			//String sql="insert into shopping_cart.customers"+"(customer_ID,customer_name,shopping_cart_ID)"+"values('6','lyu','6')";
		  //  myStmt.executeUpdate(sql);
		   // System.out.println("Insert complete");
		    
		    //3. execute SQL statement: insert into new information
			String sql="insert into shopping_cart.customers"+"(customer_ID,customer_name,shopping_cart_ID)"+"values('6','lyu','6')";
		    myStmt.executeUpdate(sql);
		    System.out.println("Insert complete");
		    
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	
}
