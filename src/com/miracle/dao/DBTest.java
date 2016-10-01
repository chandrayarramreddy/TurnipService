package com.miracle.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import com.miracle.util.Constants;

public class DBTest {

	private static final String SELECT_FROM_ORG_REL = "select * from org_rel;";
	static Statement stmt = null;
	static ResultSet rs = null;
	static Connection connection = null;
	// private PreparedStatement preparedStatement;	
	private static ResultSet resultSet;
		public static void main(String[] arg) {	
			DBTest t= new DBTest();
			//DBConnection conn= new DBConnection();
			connection=DBConnection.getDbConnection();
			try {
				stmt = connection.createStatement();
				resultSet = stmt.executeQuery(Constants.VENDOR_CUSTOMER_LIST);
				getResultSet(resultSet);
				t.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
             catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		  private static void getResultSet(ResultSet resultSet) throws Exception {
		        while(resultSet.next()){		        	
		           Integer id = resultSet.getInt("customer_id");
		         //   String text = resultSet.getString(TestTableColumns.TEXT.toString());
		            System.out.println("org_id: "+id);
		           // System.out.println("text: "+text);*/
		        }
		    }
		  public void close(){
		        try {
		            if(resultSet!=null) resultSet.close();
		            if(stmt!=null) stmt.close();
		            if(connection!=null) connection.close();
		        } catch(Exception e){}
		    }
	}


