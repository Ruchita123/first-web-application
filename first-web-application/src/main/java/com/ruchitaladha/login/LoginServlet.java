package com.ruchitaladha.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruchitaladha.todo.TodoService;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private LoginService userValidation = new LoginService();
	private TodoService todos = new TodoService();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("password", request.getParameter("password"));
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
				request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isValidUser = userValidation.isValidUser(username, password);
		if (isValidUser) {
			request.getSession().setAttribute("username", username);
			response.sendRedirect("/list-todo.do");
		} else {
			request.setAttribute("errorMessage", "Invalid Credentials");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
					request, response);
		}
	}
}
