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
 * Servlet implementation class CustomerDeleteServlet
 */
@WebServlet("/controller/CustomerDeleteServlet")
public class CustomerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDeleteServlet() {
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
		
		String CID = request.getParameter("CID");
		
		HttpSession session = request.getSession();
		
		
		if(CID != null && !CID.equals("")) {
			int ans = 0;
			CustomerDao customerdao = new CustomerDao();
			CustomerBean customer = new CustomerBean(CID,null,null,null,null);
			ans = customerdao.deleteByID(customer);
			if(ans != 1) {
				session.setAttribute("message", "删除失败！");
			}
		}
		response.sendRedirect("/CarRentalMS/admin/customerManager.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
