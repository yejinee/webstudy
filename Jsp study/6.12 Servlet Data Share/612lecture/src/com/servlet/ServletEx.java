package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// web.xml에서 Servlet 객체 가져오기
		String adminId = getServletConfig().getInitParameter("adminId");
		String adminPw = getServletConfig().getInitParameter("adminPw");

		PrintWriter out = response.getWriter();
		out.print("<p>adminId : " + adminId + "</p>");
		out.print("<p>adminPw: " + adminPw + "</p>");

		// web.xml에서 Context 객체 가져오기
		String imgDir = getServletContext().getInitParameter("imgDir");
		String testServerIP = getServletContext().getInitParameter("testServerIP");

		out.print("<p>imgDir: " + imgDir + "</p>");
		out.print("<p> testServerIP: " + testServerIP + "</p>");

		// context에 속성을 추가 -> 다른 servlet에서 data 가져오는지?

		getServletContext().setAttribute("connectedIP", "165.62.58.33");
		getServletContext().setAttribute("connectedUser", "yejin");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
