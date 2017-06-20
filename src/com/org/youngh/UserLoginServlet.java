package com.org.youngh;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domin.User;
import service.UserService;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public UserLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String email = request.getParameter("user_id");
		String pass = request.getParameter("user_pw");
		
		/*System.out.println("email : " + email);
		System.out.println("pass : " + pass);*/
		
		UserService userService = UserService.getInstance();
		User user = userService.getUser(email);
		
		boolean success = false;
		
		
		if (user!=null) {
			if (user.getPass().equals(pass)) {
				success = true;
			}else {
				success = false;
			}
		} else {
			success = false;
		}
		
		if (success) {
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("home.jsp");
			
		} else {
			response.sendRedirect("login.jsp?error=t");
		}
		
		
	}

}
