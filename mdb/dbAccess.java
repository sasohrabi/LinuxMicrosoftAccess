/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;

import net.ucanaccess.converters.TypesMap.AccessType;
import net.ucanaccess.ext.FunctionType;
import net.ucanaccess.jdbc.UcanaccessConnection;
import net.ucanaccess.jdbc.UcanaccessDriver;

public class dbAccess
{

    public static void main(String[] args)
    {
        try
        {
	    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String database = "jdbc:ucanaccess://c:\\mdb\\pardis.mdb;memory=ture";
            Connection conn = DriverManager.getConnection(database,"","");
            Statement s = conn.createStatement();

            
           /* // create a table
            String tableName = "myTable" + String.valueOf((int)(Math.random() * 1000.0));
            String createTable = "CREATE TABLE " + tableName + 
                                 " (id Integer, name Text(32))";
            s.execute(createTable); 
            
            // enter value into table
            for(int i=0; i<25; i++)
            {
              String addRow = "INSERT INTO " + tableName + " VALUES ( " + 
                     String.valueOf((int) (Math.random() * 32767)) + ", 'Text Value " + 
                     String.valueOf(Math.random()) + "')";
              s.execute(addRow);
            }
            */
            // Fetch table
            String selTable = "SELECT name FROM goods;";
            s.execute(selTable);
            ResultSet rs = s.getResultSet();
            while((rs!=null) && (rs.next()))
            {
                System.out.println(rs.getString("name"));
            }
            
            // drop the table

            
            // close and cleanup
            s.close();
            conn.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
