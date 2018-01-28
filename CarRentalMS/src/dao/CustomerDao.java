package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import bean.*;
import util.DBConnection;


public class CustomerDao {
	@SuppressWarnings("finally")
	public int add(CustomerBean customer) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "insert into Customer values(?,?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, customer.getCID());
			statement.setString(2, customer.getCname());
			statement.setString(3, customer.getWorkAddress());
			statement.setString(4, customer.getTell());
			statement.setTimestamp(5, customer.getFirstDate());
			
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
	public int updateByID(CustomerBean customer) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "update Customer set Cname=?, WorkAddress=? , Tell=? ,FirstDate=? where CID=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, customer.getCname());
			statement.setString(2, customer.getWorkAddress());
			statement.setString(3, customer.getTell());
			statement.setTimestamp(4, customer.getFirstDate());
			statement.setString(5, customer.getCID());
			
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
	public int deleteByID(CustomerBean cutomer) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "delete from Customer where CID=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, cutomer.getCID());
			
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
	public CustomerBean getByID(CustomerBean customer) {
		// TODO Auto-generated method stub
		CustomerBean result = null;
		ResultSet resultset = null;
		Connection connection = new DBConnection().LinkDB();
		String sql = "select * from Customer where CID=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, customer.getCID());
			
			resultset = statement.executeQuery();
			
			if(resultset.next()) {
				result = new CustomerBean(resultset.getString("CID"),
										  resultset.getString("Cname"),
										  resultset.getString("WorkAddress"),
										  resultset.getString("Tell"),
										  resultset.getTimestamp("FirsetDate"));
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
	public List<CustomerBean> getAll() {
		// TODO Auto-generated method stub
		List<CustomerBean> result = null;
		ResultSet resultset = null;
		try {
			Connection connection = new DBConnection().LinkDB();
			String sql = "select * from Customer";
			Statement statement = connection.createStatement();
			
			resultset = statement.executeQuery(sql);
			
			result = new LinkedList<CustomerBean>();
			while(resultset.next()) {
				String CID = resultset.getString("CID");
				String Cname = resultset.getString("Cname");
				String WorkAddress = resultset.getString("WorkAddress");
				String Tell = resultset.getString("Tell");
				Timestamp FirstDate = resultset.getTimestamp("FirstDate");
				result.add(new CustomerBean(CID, Cname, WorkAddress, Tell, FirstDate));
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
