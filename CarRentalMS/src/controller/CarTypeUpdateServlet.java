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
 * Servlet implementation class CarTypeUpdateServlet
 */
@WebServlet("/controller/CarTypeUpdateServlet")
public class CarTypeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarTypeUpdateServlet() {
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
		double Drent = Double.valueOf(request.getParameter("Drent"));
		double Mrent = Double.valueOf(request.getParameter("Mrent"));
		
		HttpSession session = request.getSession();
		
		System.out.println("修改信息为:\n"+Ctype+"\n"+Drent+"\n"+Mrent);
		
		if(!Ctype.equals("")) {
			int ans = 0;
			
			CarTypeDao cartypedao = new CarTypeDao();
			CarTypeBean cartype = new CarTypeBean(Ctype,Drent,Mrent);
			
			ans = cartypedao.updateByID(cartype);
			if(ans != 1) {
				session.setAttribute("message", "修改失败！");
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
