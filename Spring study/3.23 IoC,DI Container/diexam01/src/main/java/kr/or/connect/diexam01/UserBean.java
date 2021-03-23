package kr.or.connect.diexam01;

public class UserBean {
	private String name; // 얘로 인해 만들어지는 getName(),setName()=> name프로퍼티라고 함
	private int age;
	private boolean male;
	
	// 기본 생성자 직접 만들어주기
	public UserBean() {
		
	}
	public UserBean(String name, int age, boolean male) {
		this.name=name;
		this.age=age;
		this.male=male;
		
	}
	//getter,setter만들기 ( Source-> Generate getters and setters)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	
}
