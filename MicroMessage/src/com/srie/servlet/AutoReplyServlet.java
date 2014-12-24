package com.srie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srie.service.QueryService;

/**
 * Servlet implementation class AutoReplyServlet
 */
public class AutoReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutoReplyServlet() {
	}

	/**
	 * 自动回复功能控制层
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置字符类型
		response.setContentType("text/html;charset=utf-8");
		// 获取out对象
		PrintWriter out = response.getWriter();
		// 获取查询服务对象
		QueryService queryService = new QueryService();
		// 查询结果，并且进行输出
		out.write(queryService.queryByCommand(request.getParameter("content")));
		// 输出out内容，并且关闭out对象
		out.flush();
		out.close();
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
