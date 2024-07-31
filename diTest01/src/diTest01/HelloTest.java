package diTest01;

public class HelloTest {
	public static void main(String[] args) {
//		new MessageBean().sayHello("spring");
		// 클래스를 사용하려면 반드시 new 연산자에 의해서 객체를 생성하고 사용할 수 있다.
		
		//고쳐야할 때 객체를 생성하는 부분을 변경해야 한다.
		new MessageBeanKO().sayHello("spring");
	}
}
