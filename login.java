package usercontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAOO.Logindao;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		/*if(username.equals("rohan")&& password.equals("abc")){
			HttpSession session=request.getSession();
			session.setAttribute("user", username);//key value pair
			response.sendRedirect("WelCome.jsp");
		}
		else{
			response.sendRedirect("login.jsp");
		}
		
	*/
		Logindao dao=new Logindao();

		boolean result=dao.verifyUserCredential(username, password);
		if(result){
		
			HttpSession session=request.getSession();
			session.setAttribute("user", username);//key value pair
			response.sendRedirect("WelCome.jsp");
			
		}
		else{
			response.sendRedirect("login.jsp");
			
		}
	}
	
	

}
