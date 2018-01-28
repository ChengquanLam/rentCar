package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CarBean;
import util.DBConnection;

/**
 * Servlet implementation class ViewCarAndCarTypeServlet
 */
@WebServlet("/controller/ViewCarAndCarTypeServlet")
public class ViewCarAndCarTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCarAndCarTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		session.setAttribute("ViewCarAndCarType", getViewCarAndCarType());
		session.setAttribute("FlagViewCarAndCarType", true);
		response.sendRedirect("/CarRentalMS/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@SuppressWarnings("finally")
	private ResultSet getViewCarAndCarType() {
		// TODO Auto-generated method stub
		ResultSet resultset = null;
		try {
			Connection connection = new DBConnection().LinkDB();
			String sql = "select * from car_and_ctype_view;";
			Statement statement = connection.createStatement();
			
			resultset = statement.executeQuery(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return resultset;
		}
	}
	
}
