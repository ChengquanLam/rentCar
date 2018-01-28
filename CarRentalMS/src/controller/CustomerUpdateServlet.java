package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;
import util.TimeTrans;
import bean.*;
import java.sql.Timestamp;
import util.*;

/**
 * Servlet implementation class CustomerUpdateServlet
 */
@WebServlet("/controller/CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//返回参数值
		String CID=request.getParameter("CID");
		String Cname=request.getParameter("Cname");
		String WorkAddress=request.getParameter("WorkAddress");
		String Tell=request.getParameter("Tell");
		Timestamp FirstDate = TimeTrans.StringToTimestamp(request.getParameter("FirstDate"));
		HttpSession session = request.getSession();
		
		CustomerDao customerdao= new CustomerDao();
		CustomerBean customer = new CustomerBean(CID,Cname,WorkAddress,Tell,FirstDate);
//		System.out.println(CustomerDao.add(newcustomer));
			
		int ans = 0;
		ans = customerdao.updateByID(customer);
		if(ans != 1) {
			session.setAttribute("message","修改失败！请重新再试");
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
