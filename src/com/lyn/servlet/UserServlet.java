package com.lyn.servlet;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyn.beans.User;
import com.lyn.dao.UserDAO;
import com.lyn.util.Page;

public class UserServlet extends BaseBackServlet {

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
		List<User> userList = userDAO.list(page.getStart(),page.getCount());
		int total = userDAO.getTotal();
		page.setTotal(total);
		request.setAttribute("userList", userList);
		request.setAttribute("page", page);
		return "admin/listUser.jsp";
	}

}
