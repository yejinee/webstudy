package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginCon
 */
@WebServlet("/loginCon")
public class loginCon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String mId = request.getParameter("mID");
		String mPw = request.getParameter("mPW");

		out.print("mId : " + mId);
		out.print("mPw : " + mPw);

		// jsp file�� ���� �޾ƿ� data�� cookie���ٰ� ����
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null; // null�� �ʱ�ȭ

		// cookie �˻�
		for (Cookie c : cookies) {
			System.out.print("c.getName() : " + c.getName() + "c.getValue(): " + c.getValue());

			// cookie�� �ִ� ���
			if (c.getName().equals("memberId")) {
				cookie = c;
			}
			// cookie�� ���� ��� - ���� �������
			if (cookie == null) {
				System.out.print("cookie is null");
				cookie = new Cookie("memberId", mId);

			}
			response.addCookie(cookie);// cookie�� ���䰴ü�� ����
			cookie.setMaxAge(60 * 60); // cookie�� ��ȿ�� �� �ִ� �Ⱓ (60��)

			response.sendRedirect("loginOk.jsp"); // view�� jsp�� ����

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
