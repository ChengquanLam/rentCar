package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SubscribeBean;
import dao.SubscribeDao;

/**
 * Servlet implementation class GetOneSubscribeServlet
 */
@WebServlet("/controller/GetOneSubscribeServlet")
public class GetOneSubscribeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOneSubscribeServlet() {
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
		System.out.println("输入的CID为"+CID);
		
		SubscribeDao subscribedao = new SubscribeDao();
		List<SubscribeBean> subscribes = subscribedao.getAll();
		List<SubscribeBean> mysubscribes = new LinkedList<SubscribeBean>();
		for(SubscribeBean p : subscribes) {
			if(p.getCID().equals(CID)) {
				mysubscribes.add(p);
				System.out.println(p.getCID());
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute("subscribes",mysubscribes);
		response.sendRedirect("/CarRentalMS/admin/showOneSubscribe.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
