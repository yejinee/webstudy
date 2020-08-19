package lec819;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*
		 * ---applicationContex.xml을 사용했으므로 객체 선언 안해도 됨---- TransportationWalk trans =
		 * new TransportationWalk(); trans.move();
		 */

		// spring container에 접근 : GenericXmlApplicationContext사용 -> container파일 이름 명시
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		// container에서 (id, datatype )bean들을 가져와서 객체에 저장
		TransportationWalk trans = ctx.getBean("tWalk", TransportationWalk.class);
		trans.move();

		ctx.close(); // resource 반환

	}

}
