//import java.sql.*;
//
//public class JavaApplication1 {
//	static Connection conn = null;
//	
//		public static void main (String[] args) {
//
//			// Initialize variables for fields by data type
//			String Book_id;
//			String Title;
//	
//			int linect = 0;
//
//		try {
//			// Create a connection to the local MySQL server, with the "company" database selected.
//			//		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "mypassword");
//			// Create a connection to the local MySQL server, with the NO database selected.
//					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
//	
//			// Create a SQL statement object and execute the query.
//			Statement stmt = conn.createStatement();
//		
//			// Set the current database, if not already set in the getConnection
//			// Execute a SQL statement
//			stmt.execute("use LibrarySystem;");
//
//			// Execute a SQL query using SQL as a String object
//			ResultSet rs = stmt.executeQuery("SELECT * from Book limit 10;");
//
//			// Iterate through the result set using ResultSet class's next() method
//			System.out.print("Sl.no"+".\t");
//			System.out.print("Book_id" +"\t\t");
//			System.out.print("Title" + "\n");
//			while (rs.next()) {
//				// Keep track of the line/tuple count
//				linect++;
//				// Populate field variables
//				
//				Book_id = rs.getString("Book_id");
//				Title = rs.getString("Title");
//				
//			
//				// Do something with the data
//				
//				System.out.print(linect + "\t");
//				System.out.print(Book_id + "\t");
//				System.out.print(Title + "\n");
//				
//			} // End while(rs.next())
//
//			// Always close the recordset and connection.
//			rs.close();
//			conn.close();
//			System.out.println("Success!!");
//		} 
//		catch(SQLException ex) {
//			System.out.println("Error in connection: " + ex.getMessage());
//		}
//	}
//
//	/*
//	 *
//	 */
//	static void newln() {
//		System.out.println();
//	}
//}