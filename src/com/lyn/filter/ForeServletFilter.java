package com.lyn.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.lyn.beans.Category;
import com.lyn.beans.OrderItem;
import com.lyn.beans.User;
import com.lyn.dao.CategoryDAO;
import com.lyn.dao.OrderItemDAO;

public class ForeServletFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String contextPath = request.getServletContext().getContextPath();
		request.getServletContext().setAttribute("contextPath", contextPath);

		// 当用户登录之后，从session中获取用户对象，并根据这个用户对象获取购物车中的物品总数
		User user = (User) request.getSession().getAttribute("user");
		int cartTotalItemNumber = 0;
		if (null != user) {
			List<OrderItem> ois = new OrderItemDAO().listByUser(user.getId());
			for (OrderItem oi : ois) {
				cartTotalItemNumber += oi.getNumber();
			}
		}
		request.setAttribute("cartTotalItemNumber", cartTotalItemNumber);

		// 是用于在simpleSearch.jsp 简单搜索栏下显示分类链接用的
		List<Category> cs = (List<Category>) request.getAttribute("cs");
		if (null == cs) {
			cs = new CategoryDAO().list();
			request.setAttribute("cs", cs);
		}

		String uri = request.getRequestURI();
		uri = StringUtils.remove(uri, contextPath);
		if (uri.startsWith("/fore") && !uri.startsWith("/foreServlet")) {
			String method = StringUtils.substringAfterLast(uri, "/fore");
			request.setAttribute("method", method);
			req.getRequestDispatcher("/foreServlet").forward(request, response);
			return;
		}

		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
