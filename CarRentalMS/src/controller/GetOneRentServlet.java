package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

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
 * Servlet implementation class GetOneRentServlet
 */
@WebServlet("/controller/GetOneRentServlet")
public class GetOneRentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOneRentServlet() {
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
		System.out.println("还车，输入的CID为"+CID);
		
		RentDao rentdao = new RentDao();
		List<RentBean> rents = rentdao.getAll();
		List<RentBean> myrents = new LinkedList<RentBean>();
		for(RentBean p : rents) {
			if(p.getCID().equals(CID)) {
				myrents.add(p);
				System.out.println(p.getCID());
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute("rents",myrents);
		response.sendRedirect("/CarRentalMS/admin/showOneRent.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
