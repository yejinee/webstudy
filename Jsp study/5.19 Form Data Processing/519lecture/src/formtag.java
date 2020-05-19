
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;
import java.util.Enumeration;

@WebServlet("/formtag")
public class formtag extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(" -- doGet() -- ");

		String m_name = request.getParameter("m_name"); //날아온 data중 m_name의 값을 받아옴 
		String m_pass = request.getParameter("m_pass");
		String m_gender = request.getParameter("m_gender");
		String[] m_hobbys = request.getParameterValues("m_hobby"); // 다중선택이 가능, 여러개의 data가 들어옴 (값이 배열로 저장 )
		String m_residence = request.getParameter("m_residence");

		System.out.println("m_name : " + m_name);
		System.out.println("m_pass : " + m_pass);
		System.out.println("m_gender : " + m_gender);
		System.out.println("m_hobbys : " + Arrays.toString(m_hobbys));
		System.out.println("m_residence : " + m_residence);

		
		// data가 뭐가 날라오는지 확인해보고 싶을 때 (입력값이 아니라 name에 대한 속성값을 의미)
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			System.out.println("name : " + name);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(" -- doPost() -- "); // submit하면 출력

		doGet(request, response);// 들어온 request와 response를 do get으로 보냄 (한쪽으로 코드를 몸)

	}

}
