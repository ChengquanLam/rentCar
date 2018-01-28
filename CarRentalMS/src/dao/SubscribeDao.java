package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import bean.SubscribeBean;
import util.DBConnection;


public class SubscribeDao {

	@SuppressWarnings("finally")
	public int add(SubscribeBean subscribe) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "insert into Subscribe values(?,?,?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, subscribe.getCID());
			statement.setString(2, subscribe.getCtype());
			statement.setString(3, subscribe.getCplatenum());
			statement.setTimestamp(4, subscribe.getBook_date());
			statement.setTimestamp(5, subscribe.getRent_date());
			statement.setTimestamp(6, subscribe.getBack_date());
			
			
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
	public int updateByID(SubscribeBean subscribe) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "update Subscribe set Ctype=? ,Book_date=? ,"
				+ "Rent_date=? ,Back_date=? where CID=? and Cplatenum=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1,subscribe.getCtype());
			statement.setTimestamp(2, subscribe.getBook_date());
			statement.setTimestamp(3, subscribe.getRent_date());
			statement.setTimestamp(4, subscribe.getBack_date());
			statement.setString(5, subscribe.getCID());
			statement.setString(6, subscribe.getCplatenum());
			
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
	public int deleteByID(SubscribeBean subscribe) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "delete from Subscribe where CID=? and Cplatenum=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, subscribe.getCID());
			statement.setString(2, subscribe.getCplatenum());
			
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
	public SubscribeBean getByID(SubscribeBean scribe) {
		// TODO Auto-generated method stub
		SubscribeBean result = null;
		ResultSet resultset = null;
		Connection connection = new DBConnection().LinkDB();
		String sql = "select * from Subscribe where CID=? and Cplatenum=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, scribe.getCID());
			statement.setString(2, scribe.getCplatenum());
			
			resultset = statement.executeQuery();
			
			if(resultset.next()) {
				result = new SubscribeBean(resultset.getString("CID"),
										   resultset.getString("Ctype"),
										   resultset.getString("Cplatenum"),
										   resultset.getTimestamp("Book_date"),
										   resultset.getTimestamp("Rent_date"),
										   resultset.getTimestamp("Back_date"));
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
	public List<SubscribeBean> getAll() {
		// TODO Auto-generated method stub
		List<SubscribeBean> result = null;
		ResultSet resultset = null;
		try {
			Connection connection = new DBConnection().LinkDB();
			String sql = "select * from Subscribe";
			Statement statement = connection.createStatement();
			
			resultset = statement.executeQuery(sql);
			
			result = new LinkedList<SubscribeBean>();
			while(resultset.next()) {
				String CID = resultset.getString("CID");
				String Ctype = resultset.getString("Ctype");
				String Cplatenum = resultset.getString("Cplatenum");
				Timestamp Book_date = resultset.getTimestamp("Book_date");
				Timestamp Rent_date = resultset.getTimestamp("Rent_date");
				Timestamp Back_date = resultset.getTimestamp("Back_date");
				result.add(new SubscribeBean(CID, Ctype, Cplatenum, Book_date, Rent_date , Back_date));
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
