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
 * Servlet implementation class CarUpdateServlet
 */
@WebServlet("/controller/CarUpdateServlet")
public class CarUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarUpdateServlet() {
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
		String Ctype = request.getParameter("Ctype");
		String Cpurdate = request.getParameter("Cpurdate");
		String Ccondition = request.getParameter("Ccondition");
		HttpSession session = request.getSession();
		
		System.out.println("修改信息为:\n"+Cplatenum+"\n"+Ctype+"\n"+Cpurdate+"\n"+Ccondition);
		
		if(!Cplatenum.equals("") && !Ctype.equals("") && !Cpurdate.equals("") && !Ccondition.equals("")) {
			int ans = 0;
			CarDao cardao = new CarDao();
			CarBean car = new CarBean(Cplatenum,Ctype,Cpurdate,Ccondition);
			ans = cardao.updateByID(car);
			if(ans != 1) {
				session.setAttribute("message", "修改失败！");
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
