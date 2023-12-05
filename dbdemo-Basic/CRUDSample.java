package com.scb.dbdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDSample {

	private Connection conn;
	public CRUDSample(){
		this.conn= DBConnection.getConnection();
	}
	
	public void getAllEmployees() {
		String query="select * from employee";
		try {
			Statement stmt= conn.createStatement();
			ResultSet result=stmt.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getInt(1)+" "+
			result.getString(2)+" "+result.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void getEmployeebyId(int id) {
		String query="select * from employee where id=?";
		try {
			PreparedStatement stmt= conn.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet result=stmt.executeQuery();
			while(result.next()) {
				System.out.println(result.getInt(1)+" "+
			result.getString(2)+" "+result.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void deleteEmployee(int id) {
		String query= "delete from employee where id= ?";
		try {
			PreparedStatement stmt= conn.prepareStatement(query);
			stmt.setInt(1, id);
			int x= stmt.executeUpdate();
			if(x>0) {
				System.out.println("Employee deleted");
			}else {
				System.out.println("Error while updating employee");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateEmployee(String name,int id) {
		String query= "update employee set name=? where id= ?";
		try {
			PreparedStatement stmt= conn.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setInt(2, id);
			int x= stmt.executeUpdate();
			if(x>0) {
				System.out.println("Employee updated");
			}else {
				System.out.println("Error while updating employee");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int insertData(String name, String email) throws SQLException {
		
		String query="insert into employee (name,email) values(?,?)";
		PreparedStatement pst= conn.prepareStatement(query);
		
		pst.setString(1, name);
		pst.setString(2, email);
		
		return pst.executeUpdate();
	}
}
