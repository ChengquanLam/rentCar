package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import bean.*;
import util.DBConnection;


public class CarTypeDao {
	@SuppressWarnings("finally")
	public int add(CarTypeBean cartype) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "insert into CarType values(?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, cartype.getCtype());
			statement.setDouble(2, cartype.getDrent());
			statement.setDouble(3, cartype.getMrent());
			
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
	public int updateByID(CarTypeBean cartype) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "update CarType set Drent=?, Mrent=? where Ctype=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setDouble(1, cartype.getDrent());
			statement.setDouble(2, cartype.getMrent());
			statement.setString(3, cartype.getCtype());
			
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
	public int deleteByID(CarTypeBean cartype) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "delete from CarType where CType=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, cartype.getCtype());
			
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
	public CarTypeBean getByID(CarTypeBean cartype) {
		// TODO Auto-generated method stub
		CarTypeBean result = null;
		ResultSet resultset = null;
		Connection connection = new DBConnection().LinkDB();
		String sql = "select * from CarType where Ctype=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, cartype.getCtype());
			
			resultset = statement.executeQuery();
			
			if(resultset.next()) {
				result = new CarTypeBean(resultset.getString("Ctype"),
									 resultset.getDouble("Drent"),
									 resultset.getDouble("Mrent"));
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
	public List<CarTypeBean> getAll() {
		// TODO Auto-generated method stub
		List<CarTypeBean> result = null;
		ResultSet resultset = null;
		try {
			Connection connection = new DBConnection().LinkDB();
			String sql = "select * from CarType";
			Statement statement = connection.createStatement();
			
			resultset = statement.executeQuery(sql);
			
			result = new LinkedList<CarTypeBean>();
			while(resultset.next()) {
				String Ctype = resultset.getString("Ctype");
				double Drent = resultset.getDouble("Drent");
				double Mrent = resultset.getDouble("Mrent");
				result.add(new CarTypeBean(Ctype, Drent, Mrent));
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
