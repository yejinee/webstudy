package kr.or.connect.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired //알아서 Engine타입의 객체 있으면  v8에 주입해달라는 것(setter없어도 됌)
	private Engine v8;
	public Car() {
		
		//객체 생성 시 언제 생성되는지 확인
		System.out.println("Car");
	}
	//없애기 + 대신 어노테이션 붙이기
	//Engine 메서드 실행될 때, Engine 타입의 엔진을 받아와서 car의 엔진인 v8에 넣어줌 
	public void setEngine(Engine e) {
		this.v8 = e;
	}
	
	// 자동차가 달릴 때 사용하는 메서드
	public void run() {
		System.out.println("엔진사용해서 달림");
		v8.exec();//엔진이 가진 exec메서드 실행
	}
	// 실제 car class가 동작하려면 이러한 순서로 코드 작성해야함 
	// But Spring IoC 컨테이너가 알아서 만들어줌으로 이렇게 할 필요 X
	/*
	public static void main(String[] args) {
		Engine e=new Engine();
		Car c= new Car();
		c.setEngine(e); // car에 engine을 넣어줌
		c.run();
	}
	*/
	
}
