package controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.*;
import dao.*;
import util.*;
/**
 * Servlet implementation class CustomerInsertServlet
 */
@WebServlet("/controller/CustomerInsertServlet")
public class CustomerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerInsertServlet() {
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
		Timestamp FirstDate =  TimeTrans.StringToTimestamp(request.getParameter("FirstDate"));
		HttpSession session = request.getSession();
		
		if(!CID.equals("")) {
			int ans = 0;
			
			CustomerDao customerdao= new CustomerDao();
			CustomerBean customer = new CustomerBean(CID,Cname,WorkAddress,Tell,FirstDate);
			
			ans = customerdao.add(customer);
			
			if(ans != 1) {
				session.setAttribute("message", "添加失败！");
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
