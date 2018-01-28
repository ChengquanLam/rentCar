package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import util.DBConnection;


import bean.*;
public class CarDao {
	
	@SuppressWarnings("finally")
	public int add(CarBean car) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "insert into Car values(?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, car.getCplatenum());
			statement.setString(2, car.getCtype());
			statement.setString(3, car.getCpurdate());
			statement.setString(4, car.getCcondition());
			
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
	public int updateByID(CarBean car) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "update Car set Ctype=?, Cpurdate=?, Ccondition=? where Cplatenum=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, car.getCtype());
			statement.setString(2, car.getCpurdate());
			statement.setString(3, car.getCcondition());
			statement.setString(4, car.getCplatenum());
			
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
	public int deleteByID(CarBean car) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = new DBConnection().LinkDB();
		String sql = "delete from Car where Cplatenum=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, car.getCplatenum());
			
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
	public CarBean getByID(CarBean car) {
		// TODO Auto-generated method stub
		CarBean result = null;
		ResultSet resultset = null;
		Connection connection = new DBConnection().LinkDB();
		String sql = "select * from Car where Cplatenum=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, car.getCplatenum());
			
			resultset = statement.executeQuery();
			
			if(resultset.next()) {
				result = new CarBean(resultset.getString("Cplatenum"),
									 resultset.getString("Ctype"),
									 resultset.getString("Cpurdate"),
									 resultset.getString("Ccondition"));
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
	public List<CarBean> getAll() {
		// TODO Auto-generated method stub
		List<CarBean> result = null;
		ResultSet resultset = null;
		try {
			Connection connection = new DBConnection().LinkDB();
			String sql = "select * from Car";
			Statement statement = connection.createStatement();
			
			resultset = statement.executeQuery(sql);
			
			result = new LinkedList<CarBean>();
			while(resultset.next()) {
				String Cplatenum = resultset.getString("Cplatenum");
				String Ctype = resultset.getString("Ctype");
				String Cpurdate = resultset.getString("Cpurdate");
				String Ccondition = resultset.getString("Ccondition");
				result.add(new CarBean(Cplatenum, Ctype, Cpurdate, Ccondition));
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
