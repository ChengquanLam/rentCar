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
import util.TimeTrans;

/**
 * Servlet implementation class SubscribeInsertServlet
 */
@WebServlet("/controller/SubscribeInsertServlet")
public class SubscribeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubscribeInsertServlet() {
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
		String Cplatenum = request.getParameter("Cplatenum");
		String Ctype = request.getParameter("Ctype");
		Timestamp Book_date = new Timestamp(System.currentTimeMillis());
		Timestamp Rent_date = TimeTrans.StringToTimestamp(request.getParameter("Rent_date"));
		Timestamp Back_date = TimeTrans.StringToTimestamp(request.getParameter("Back_date"));
		HttpSession session = request.getSession();
		
		System.out.println("添加预约信息：\n" + CID + Cplatenum + Ctype + Book_date + Rent_date + Back_date);
		
		if(!CID.equals("") && !Cplatenum.equals("")) {
			int ans = 0;
			
			SubscribeDao subscribedao= new SubscribeDao();
			SubscribeBean subscribe = new SubscribeBean(CID,Ctype,Cplatenum,Book_date,Rent_date,Back_date);
			
			ans = subscribedao.add(subscribe);
			
			if(ans != 1) {
				session.setAttribute("message", "预约失败！请稍后再试");
			}
			else {
				session.setAttribute("message", "预约成功！");
			}
		}
		response.sendRedirect("/CarRentalMS/index.jsp"); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
