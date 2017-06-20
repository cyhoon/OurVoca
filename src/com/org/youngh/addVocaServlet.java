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

@WebServlet("/addVocaServlet")
public class addVocaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addVocaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if( user.getEmail() == null) {
			response.sendRedirect("login.jsp");
		}else {
		
			String user_email = user.getEmail(); // ���� �̸���
			String title = request.getParameter("title"); // �ܾ��� ����
			String voca_desc = request.getParameter("desc"); // �ܾ��� ����
			
			/*System.out.println("���� �̸��� : " + user_email);
			System.out.println("�ܾ��� ���� : " +title);
			System.out.println("�ܾ��� ���� : " +voca_desc);*/
			
			UserService userService = UserService.getInstance();
			userService.addVoca(title, voca_desc, user_email);
			
			response.sendRedirect("vocaList.jsp");
		
		}
		
	}

}
