package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		try {
			List list = model.search(bean, 0, 0);

			request.setAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rb = request.getRequestDispatcher("UserListView.jsp");
		rb.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		if (op.equals("search")) {
			bean.setFirstName(request.getParameter("firstName"));
			bean.setLastName(request.getParameter("lastName"));
		}

		if (op.equals("delete")) {
			String[] ids = request.getParameterValues("ids");
			for (String id : ids) {
				try {
					model.delete(Integer.parseInt(id));
					request.setAttribute("successMsg", "record deleted successfully");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		try {
			List list = model.search(bean, 0, 0);

			request.setAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rb = request.getRequestDispatcher("UserListView.jsp");
		rb.forward(request, response);

	}
}
