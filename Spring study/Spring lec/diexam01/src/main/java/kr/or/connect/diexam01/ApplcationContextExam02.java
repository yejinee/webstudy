package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplcationContextExam02 {
	public static void main(String[] args) {
		// spring container 중 ApplicationContext사용
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		// car 객체 만드는 데 applicationcontext한테 요청
		Car car=(Car)ac.getBean("c"); // id
		car.run();
	}
}
