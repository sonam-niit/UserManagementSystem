package com.scb.ums.main;

import java.util.List;
import java.util.Scanner;

import com.scb.ums.dao.UserDao;
import com.scb.ums.daoimpl.UserDaoImpl;
import com.scb.ums.model.User;

public class UserManagementSystem {

	public static void main(String[] args) {
		
		UserDao dao= new UserDaoImpl();//Data Abstarction
		//dao ref variable of interface
		//object class which implements UserDao interface
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter 1 for AddUser\n2 for update user\n3 for Delete user\n4 for GetAll");
		
		int input= sc.nextInt();
		switch (input) {
		case 1:
			sc.nextLine();
			System.out.println("Enter Name");
			String name= sc.nextLine();
			System.out.println("Enter Email");
			String email= sc.nextLine();
			System.out.println("Enter Username");
			String username= sc.nextLine();
			int res=dao.createUser(new User(name, email, username));
			if(res>0) {
				System.out.println("Inserted");
			}else {
				System.out.println("Not Inserted");
			}
			break;
		case 3:
			System.out.println("Enter Id for delete");
			int id= sc.nextInt();
			if(dao.deleteUser(id)) {
				System.out.println("User deleted");
			}else {
				System.out.println("No user avaialble to delete with id "+id);
			}
			break;
		case 4:
			List<User> list= dao.getAllUsers();
			System.out.println(list);
			break;
		default:
			break;
		}
	}
}
