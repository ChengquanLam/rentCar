package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CarBean;
import dao.CarDao;

/**
 * Servlet implementation class CarDeleteServlet
 */
@WebServlet("/controller/CarDeleteServlet")
public class CarDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarDeleteServlet() {
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
		
		String Cplatenum = request.getParameter("Cplatenum");
		
		HttpSession session = request.getSession();
		
		
		if(Cplatenum != null && !Cplatenum.equals("")) {
			int ans = 0;
			CarDao cardao = new CarDao();
			CarBean car = new CarBean(Cplatenum,null,null,null);
			ans = cardao.deleteByID(car);
			if(ans != 1) {
				session.setAttribute("message", "删除失败！");
			}
		}
		response.sendRedirect("/CarRentalMS/admin/carManager.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
