package diTest02;

public class HelloApp {
	public static void main(String[] args) {
//		MessageBean msg=new MessageBeanEn();
//		msg.sayHello("spring");
		
		//변수의 타입을 바꾸지 않고 객체만 바꾸면 된다
		//인터페이스를 사용한 수정
		MessageBean msg=new MessageBeanKO();
		msg.sayHello("spring");
	}
}
