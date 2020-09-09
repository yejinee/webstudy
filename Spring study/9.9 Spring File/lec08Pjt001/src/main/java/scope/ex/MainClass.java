package scope.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		InjectionBean injectionBean = ctx.getBean("injectionBean", InjectionBean.class);

		// 2개가 같은 객체를 참조하는지 확인해보는 code
		DependencyBean dependencyBean01 = ctx.getBean("dependencyBean", DependencyBean.class);

		DependencyBean dependencyBean02 = ctx.getBean("dependencyBean", DependencyBean.class);

		if (dependencyBean01.equals(dependencyBean02)) {
			System.out.println("dependencyBean01 == dependencyBean02");
		} else {
			System.out.println("dependencyBean01 != dependencyBean02");
		}
		// 1. singleton인 경우 -> 같은 객체를 참조함
		// 2. prototype인 경우 -> 다른 객체를 생성함

		ctx.close();

	}

}
