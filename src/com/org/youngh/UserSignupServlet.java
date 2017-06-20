package com.org.youngh;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/UserSignupServlet")
public class UserSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserSignupServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String age = request.getParameter("age");
		
		UserService userService = UserService.getInstance();
		boolean result = userService.registerUser(email, pass, name, age);
		
		boolean code = false;
		String message = "";
		
		if(result){
			code = true;
			message = "회원가입이 정상적으로 되었습니다.";
		}else {
			code = false;
			message = "이메일이 중복되었습니다.";
		}
		
		request.setAttribute("code", code);
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
		rd.forward(request, response);
		
	}

}
