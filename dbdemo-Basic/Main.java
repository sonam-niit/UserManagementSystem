package com.scb.dbdemo;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {

		CRUDSample sample = new CRUDSample();
		//sample.getAllEmployees();
		//.updateEmployee("Aditya Shah",2);
		sample.deleteEmployee(1);
//		try {
//			int res=sample.insertData("Aishwarya", "aish@gmail.com");
//			if(res>0) {
//				System.out.println("Data Inserted");
//			}else {
//				System.out.println("Error while inserting data");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
