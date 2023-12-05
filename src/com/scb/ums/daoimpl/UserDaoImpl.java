package com.scb.ums.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scb.ums.dao.UserDao;
import com.scb.ums.model.User;
import com.scb.ums.utility.DBConnection;

public class UserDaoImpl implements UserDao{

	@Override
	public int createUser(User user) {
		int result=0;
		Connection conn= DBConnection.getConnection();
		String query= "insert into users (name,email,username) values(?,?,?)";
		try {
			PreparedStatement stmt= conn.prepareStatement(query);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getUsername());
			
			result=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public List<User> getAllUsers() {
		Connection conn= DBConnection.getConnection();
		String query= "select * from users";
		try {
			PreparedStatement pst= conn.prepareStatement(query);
			ResultSet rst=pst.executeQuery();
			List<User> list= new ArrayList<>();
			
			while(rst.next()) {
				User u = new User(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4));
				list.add(u);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public User updateUser(User user, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean res=false;
		Connection conn= DBConnection.getConnection();
		String query= "delete from users where id=?";
		try {
			PreparedStatement stmt= conn.prepareStatement(query);
			stmt.setInt(1, id);
			
			int x= stmt.executeUpdate();
			if(x>0) {
				res=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
