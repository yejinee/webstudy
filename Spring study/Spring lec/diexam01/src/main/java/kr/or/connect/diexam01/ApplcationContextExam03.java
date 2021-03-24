package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplcationContextExam03 {
	public static void main(String[] args) {
		// AnnotationConfigApplicationContext 이용해주기 (설정을 가지고 있는 class를 읽어들임)
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		// bean들을 이미 만들어서 가지고 있음 -> 사용자가 요청시 알맞은 결과 줌
		//Car car = (Car)ac.getBean("car"); //public Car car 가져다 써야함
		Car car = (Car)ac.getBean(Car.class); //class type을 넣어줌 
		car.run();
		
	}
}
