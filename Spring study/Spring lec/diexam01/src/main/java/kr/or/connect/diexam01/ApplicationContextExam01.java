package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {
	
	public static void main(String[] args) {
		// spring이 가진 공장 생성
		//applicationContext 인터페이스를 구현하고 있는 객체들 중 ClassPathXmlApplicationContext겍채 생성
		//공장한테 classpath의 정보를 읽어서 공장을 세우라고 말해주는 것
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("초기화 ");
		
		// 공장을 이용해서 정보 얻어내기
		// 직접 생성하지는 않고 공장한테 getbean메서드 이용해서 얻어냄
		// getbean은 object타입으로 리턴 하므로 형변환 필요
		// userBean과 id가 일치하는 애가 있는지 찾음 -> 찾으면 id와 같이 등록된 클래스 이름 알아내고 생성 -> 생성한 class 리턴 
		UserBean userBean=(UserBean)ac.getBean("userBean");
		userBean.setName("kang");
		System.out.println(userBean.getName());
		
		
		UserBean userBean2=(UserBean)ac.getBean("userBean");
		if(userBean==userBean2)
			System.out.println("같은 인스턴스");
		userBean2.setName("kim");
		System.out.println(userBean2.getName());
		System.out.println(userBean.getName());
	}

}
