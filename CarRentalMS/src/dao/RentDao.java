package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import bean.RentBean;
import util.DBConnection;


public class RentDao {

	@SuppressWarnings("finally")
	public int add(RentBean rent) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "insert into Rent values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, rent.getCID());
			statement.setString(2, rent.getCplatenum());
			statement.setString(3, rent.getRentType());
			statement.setTimestamp(4, rent.getSubBack_date());
			statement.setDouble(5, rent.getSubRent());
			statement.setDouble(6, rent.getDeposit());
			statement.setTimestamp(7, rent.getBack_date());
			statement.setDouble(8, rent.getRent());
			
			
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
	public int updateByID(RentBean rent) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "update Rent set RentType=? ,SubBack_date=? ,"
				+ "SubRent=? ,Deposit=? ,Back_date=? ,Rent=? where CID=? and Cplatenum=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, rent.getRentType());
			statement.setTimestamp(2, rent.getSubBack_date());
			statement.setDouble(3, rent.getSubRent());
			statement.setDouble(4, rent.getDeposit());
			statement.setTimestamp(5, rent.getBack_date());
			statement.setDouble(6, rent.getRent());
			statement.setString(7, rent.getCID());
			statement.setString(8, rent.getCplatenum());
			
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
	public int deleteByID(RentBean rent) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "delete from Rent where CID=? and Cplatenum=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, rent.getCID());
			statement.setString(2, rent.getCplatenum());
			
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
	public RentBean getByID(RentBean rent) {
		// TODO Auto-generated method stub
		RentBean result = null;
		ResultSet resultset = null;
		Connection connection = new DBConnection().LinkDB();
		String sql = "select * from Rent where CID=? and Cplatenum=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, rent.getCID());
			statement.setString(2, rent.getCplatenum());
			
			resultset = statement.executeQuery();
			
			if(resultset.next()) {
				result = new RentBean(resultset.getString("CID"),
									  resultset.getString("Cplatenum"),
									  resultset.getString("RentType"),
									  resultset.getTimestamp("SubBack_date"),
									  resultset.getDouble("SubRent"),
									  resultset.getDouble("Deposit"),
									  resultset.getTimestamp("Back_date"),
									  resultset.getDouble("Rent"));
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
	public List<RentBean> getAll() {
		// TODO Auto-generated method stub
		List<RentBean> result = null;
		ResultSet resultset = null;
		try {
			Connection connection = new DBConnection().LinkDB();
			String sql = "select * from Rent";
			Statement statement = connection.createStatement();
			
			resultset = statement.executeQuery(sql);
			
			result = new LinkedList<RentBean>();
			while(resultset.next()) {
				String CID = resultset.getString("CID");
				String Cplatenum = resultset.getString("Cplatenum");
				String RentType = resultset.getString("RentType");
				Timestamp SubBack_date = resultset.getTimestamp("SubBack_date");
				double SubRent = resultset.getDouble("SubRent");
				double Deposit = resultset.getDouble("Deposit");
				Timestamp Back_date = resultset.getTimestamp("Back_date");
				Double Rent = resultset.getDouble("Rent");
				result.add(new RentBean(CID, Cplatenum, RentType, SubBack_date ,SubRent, Deposit, Back_date, Rent));
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
