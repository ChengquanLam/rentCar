package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.*;
import dao.*;
import bean.*;
/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/controller/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
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
		
		HttpSession session = request.getSession();
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Verify_code = request.getParameter("Verify_code");
		
		if(Verify_code != null && session.getAttribute("verCode") != null && session.getAttribute("verCode").equals(Verify_code.toLowerCase())) {
			
			UsersDao usersdao = new UsersDao();
			UsersBean user = usersdao.getByID(new UsersBean(Username,null,null,null,null,null));
			
			System.out.println("用户名和密码：\n"+user.getUsername()+"\n"+user.getPassword());
			
			if(user != null && user.getPassword().equals(Password)) {
				response.sendRedirect("/CarRentalMS/admin/console.jsp");
				
				session.setAttribute("username", user.getUsername());
				session.setAttribute("usertype", user.getUrole());
				session.setAttribute("user", user);
				
				//request.getRequestDispatcher("/admin/console.jsp").forward(request,response);
			}else {
				
				response.sendRedirect("/CarRentalMS/admin/adminLogin.jsp");
				
				session.setAttribute("message", "登录失败，请重新登录！");
			}
		}else {
			response.sendRedirect("/CarRentalMS/admin/adminLogin.jsp");
			
			session.setAttribute("message", "验证码错误！");
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
