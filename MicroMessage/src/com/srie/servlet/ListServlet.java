package com.srie.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srie.service.QueryService;

/**
 * �б�ҳ���ʼ������ Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ListServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("UTF-8");
		// 接收页面的值
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		// 向页面传值
		request.setAttribute("command", command);
		request.setAttribute("description", description);
		QueryService listService = new QueryService();
		// 查询消息列表并传给页面
		request.setAttribute("messageList",
				listService.queryMessagList(command, description));
		// 向页面跳转
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
