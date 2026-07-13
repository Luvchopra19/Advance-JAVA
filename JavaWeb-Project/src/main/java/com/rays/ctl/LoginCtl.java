package com.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		session.invalidate();

		RequestDispatcher rb = request.getRequestDispatcher("LoginView.jsp");
		rb.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		try {

			bean = model.authenticate(login, password);
			if (bean != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", bean);
				response.sendRedirect("WelcomeCtl");
				return;
			} else {
				System.out.println("invalid login or password");
				request.setAttribute("errorMsg", "invalid login or password");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		RequestDispatcher rb = request.getRequestDispatcher("LoginView.jsp");
		rb.forward(request, response);
	}

}
