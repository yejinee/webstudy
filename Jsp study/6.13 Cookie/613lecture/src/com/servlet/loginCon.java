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

		// jsp file로 부터 받아온 data를 cookie에다가 저장
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null; // null로 초기화

		// cookie 검색
		for (Cookie c : cookies) {
			System.out.print("c.getName() : " + c.getName() + "c.getValue(): " + c.getValue());

			// cookie가 있는 경우
			if (c.getName().equals("memberId")) {
				cookie = c;
			}
			// cookie가 없는 경우 - 새로 만들어줌
			if (cookie == null) {
				System.out.print("cookie is null");
				cookie = new Cookie("memberId", mId);

			}
			response.addCookie(cookie);// cookie를 응답객체에 전송
			cookie.setMaxAge(60 * 60); // cookie가 유효할 수 있는 기간 (60분)

			response.sendRedirect("loginOk.jsp"); // view를 jsp로 전송

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
