package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import bean.UsersBean;
import util.DBConnection;


public class UsersDao {

	@SuppressWarnings("finally")
	public int add(UsersBean user) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "insert into Users values(?,?,?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getUsex());
			statement.setString(4, user.getUname());
			statement.setString(5, user.getUrole());
			statement.setString(6, user.getUID());
			
			
			result = statement.executeUpdate();
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	public int updateByID(UsersBean user) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "update Users set Password=? ,Usex=? ,"
				+ "Uname=? ,Urole=? ,UID=? where Username=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getPassword());
			statement.setString(2, user.getUsex());
			statement.setString(3, user.getUname());
			statement.setString(4, user.getUrole());
			statement.setString(5, user.getUID());
			statement.setString(6, user.getUsername());
			
			result = statement.executeUpdate();
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	public int deleteByID(UsersBean user) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "delete from Users where Username=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getUsername());
			
			result = statement.executeUpdate();
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	public UsersBean getByID(UsersBean user) {
		// TODO Auto-generated method stub
		UsersBean result = null;
		ResultSet resultset = null;
		Connection connection = new DBConnection().LinkDB();
		String sql = "select * from Users where Username=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, user.getUsername());
			
			resultset = statement.executeQuery();
			
			if(resultset.next()) {
				result = new UsersBean(resultset.getString("Username"),
										resultset.getString("Password"),
										resultset.getString("Usex"),
										resultset.getString("Uname"),
										resultset.getString("Urole"),
										resultset.getString("UID"));
			}
			
			resultset.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	public List<UsersBean> getAll() {
		// TODO Auto-generated method stub
		List<UsersBean> result = null;
		ResultSet resultset = null;
		try {
			Connection connection = new DBConnection().LinkDB();
			String sql = "select * from User";
			Statement statement = connection.createStatement();
			
			resultset = statement.executeQuery(sql);
			
			result = new LinkedList<UsersBean>();
			while(resultset.next()) {
				String Username = resultset.getString("Username");
				String Password = resultset.getString("Password");
				String Usex = resultset.getString("Usex");
				String Uname = resultset.getString("Uname");
				String Urole = resultset.getString("Urole");
				String UID = resultset.getString("UID");
				result.add(new UsersBean(Username, Password, Usex, Uname, Urole , UID));
			}
			
			resultset.close();
			statement.close();
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return result;
		}
	}
}
