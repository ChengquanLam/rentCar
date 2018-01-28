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
 * Servlet implementation class RentUpdateServlet
 */
@WebServlet("/controller/RentUpdateServlet")
public class RentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentUpdateServlet() {
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
		Timestamp SubBack_date = Timestamp.valueOf(request.getParameter("SubBack_date"));
		double SubRent = Double.valueOf(request.getParameter("SubRent"));
		double Deposit = Double.valueOf(request.getParameter("Deposit"));
		Timestamp Back_date = TimeTrans.StringToTimestamp(request.getParameter("Back_date"));
		double Rent = Double.valueOf(request.getParameter("Rent"));
		
		HttpSession session = request.getSession();
		
		System.out.println("修改信息为:\n"+CID+"\n"+Back_date+"\n"+Rent);
		
		if(!Ctype.equals("")) {
			int ans = 0;
			
			RentDao rentdao = new RentDao();
			RentBean rent = new RentBean(CID,Cplatenum,Ctype,SubBack_date,SubRent,Deposit,Back_date,Rent);
			
			ans = rentdao.updateByID(rent);
			
			System.out.println(rent.toString());
			
			System.out.println("ans=" + ans);
			
			if(ans != 1) {
				session.setAttribute("message", "还车失败！请稍后再试");
				response.sendRedirect("/CarRentalMS/admin/showOneRent.jsp");
			}else {
				session.setAttribute("message", "还车成功！");
				response.sendRedirect("/CarRentalMS/admin/returnCar.jsp");
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
