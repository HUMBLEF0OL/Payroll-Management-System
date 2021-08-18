// this class is for establishing the connection 
//between Netbeans and database

import java.sql.*;
//we have to include the MySQL.jdbc library to our project

/**
 *
 * @author HUMBLEFOOL
 */
public class conn {
//  creating 2 interfaces
//  connection is for connecting java application with database

	public Connection c;
//  for executing the sql queries

	public Statement s;
//  creating a constructor of the class

	public conn() {
		try {
//          registering the drivers of MySQL drivers

			Class.forName("com.mysql.jdbc.Driver");
			// project2 is the name of database
			// root is admin and "" is the password

			c = DriverManager.getConnection("jdbc:mysql:///project2", "root", "");
			// creating a statement and storing in s

			s = c.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// we have used try and catch for handling the unchecked exceptions(exceptions
		// which are not known to complier like external files)

	}
}
