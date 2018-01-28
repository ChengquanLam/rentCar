package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;
import dao.*;

/**
 * Servlet implementation class CarTypeDeleteServlet
 */
@WebServlet("/controller/CarTypeDeleteServlet")
public class CarTypeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarTypeDeleteServlet() {
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
		
		String Ctype = request.getParameter("Ctype");
		
		HttpSession session = request.getSession();
		
		if(Ctype != null && !Ctype.equals("")) {
			int ans = 0;
			
			CarTypeDao cartypedao = new CarTypeDao();
			CarTypeBean cartype = new CarTypeBean(Ctype,0,0);
			ans = cartypedao.deleteByID(cartype);
			
			if(ans != 1) {
				session.setAttribute("message", "删除失败！");
			}
		}
		response.sendRedirect("/CarRentalMS/admin/carTypeManager.jsp");
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
