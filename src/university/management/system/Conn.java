package university.management.system;

import java.sql.*;

/*  5 steps of Java database connectivity  - JDBC
1. Register the Driver class
2. Creating connection string
3. Creating statement
4. Executing MySQL Queries
5. Closing the Connection
 */

public class Conn {
    Connection c;
    Statement s;
    Conn(){
    
        //here mySQL may lead to exception as it is an external entity, it is not in project
        //try and catch will help to print the exception
        try{
            //1st step - Register driver class
            Class.forName("com.mysql.cj.jdbc.Driver");  //here Driver is class and com.mysql.cj.jdbc is 
            //2nd step - creating connection string
            c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem", "root", "Viniya@123"); //(database name, username, password of MySQL workbench)
            //3rd step - creating Statement
            s = c.createStatement();       //we can execute sql queries with the help of statement
        }   catch (Exception e) {
                e.printStackTrace();    //it will print the stack  trace in case of esception
        }
    }
}
