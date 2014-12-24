package com.srie.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srie.service.MaintainService;

/**
 * Servlet implementation class DeleteBatchServlet
 */
public class DeleteBatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBatchServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		//接收页面的值
		String [] ids = request.getParameterValues("ids");
		//调用批量删除服务
		MaintainService maintainService = new MaintainService();
		maintainService.deleteBatch(ids);
		//设置删除成功提示
		request.setAttribute("delOK", "delOK");
		//向页面跳转
		request.getRequestDispatcher("/List.action").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
