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
 * Servlet implementation class SubscribeInsertServlet
 */
@WebServlet("/controller/RentInsertServlet")
public class RentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentInsertServlet() {
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
		String Ctype = request.getParameter("RentType");
		
		//车辆预约得到的车辆预约还车时间是String型，需要转换成date插入数据库
		Timestamp SubBack_date = TimeTrans.StringToTimestamp(request.getParameter("SubBack_date"));
		double SubRent = Double.valueOf(request.getParameter("SubRent"));
		double Deposit = Double.valueOf(request.getParameter("Deposit"));
		
		//租车时，该text为空
		Timestamp Back_date;
		
		System.out.println(request.getParameter("SubBack_date"));
		
		HttpSession session = request.getSession();
		System.out.println("添加测信息为:\n"+Cplatenum+"\n"+Ctype+"\n"+CID+"\n");
		
		if(!CID.equals("") && !Cplatenum.equals("")) {
			int ans = 0;
			RentDao rentdao = new RentDao();
			RentBean rent = new RentBean(CID,Cplatenum,Ctype,SubBack_date,SubRent,Deposit,null,0);
			ans = rentdao.add(rent);
			if(ans != 1) {
				session.setAttribute("message", "提车失败！请稍后再试");
				response.sendRedirect("/CarRentalMS/admin/getCar.jsp");
			}else {
				session.setAttribute("message","恭喜您！提车成功");
				response.sendRedirect("/CarRentalMS/admin/showOneSubscribe.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
