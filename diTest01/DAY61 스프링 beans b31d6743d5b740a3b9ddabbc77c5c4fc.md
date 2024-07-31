# DAY61 : 스프링 beans

date: July 31, 2024
subject: java, spring
공부한 곳: KOSTA

# 🐾 **T I L 240731 (ฅ•.•ฅ)**

✅ 스프링 bean

✅ application context

✅ 다양한 버전의 생성자를 가진 클래스 설정방법

# ☀ 오전

---

## 스프링 기본 개념학습

DI와 AOP는 입사시험에서 잘 나오는 개념이다( AOP는 추후 수업)

교과서처럼 달달 외우기보다 개념을 잘 잡아서 나만의 언어로 말하는 것이 중요하다

### 프레임워크

우리가 학습했던 jsp MVC 패턴의 경우를 보면 kosta.properties파일을 만들어서 사용자의 요청 별 일처리를 위한 Action 클래스를 설정하고, FrontController 역할을 하는 DispatcherServlet 클래스를 만들고 모든 Action들이 가져야 할 공통적인 메서드를 일반화한 Action인터페이스를 만들었다.

만약, 신규 프로젝트에 투입된다면 이러한 뼈대를 그대로 가져다가 사용하면 개발시간을 단축시킬 수 있다.

이와 같이 어플리케이션 개발에 필요한 기반 틀(뼈대)를 이루는 환경을 “프레임워크”라고 한다.

개발 연차가 쌓일 수록 자신만의 프레임워크가 보다 더 정교해질 것이다. 또, 개발회사마다 자신들만의 프레임워크를 만들어서 개발에 적용하기도 한다.

이러한 프레임워크 중에 전 세계적으로 가장 사랑받고 있는 것이 바로 스프링Spring이다.

또 우리 나라의 경우 공공프로젝트의 표준 프레임워크에 스프링이 포함되어 있다.

### 스프링의 주요 특징

- DI
- AOP

### 🌟 DI - Dependency Injection

DI란? 의존성주입

스프링 컨테이너가 지원하는 핵심 개념 중의 하나

사용자 요구에 의해 수정이 될 것 같은 객체의 생성을 어플리케이션 내에서 직접 new 연산자에 의해서 생성하지 않고 스프링 환경설정 파일에 의해서 생성하는 것을 말한다.

자바로 된 소프트웨서 속을 들여다보면 수많은 클래스들로 구성되어있는데, 이러한 클래스들은 상속관계, 포함관계를 맺을 수 있다.

포함관계에 있는 두 클래스 A,B에서 A클래스는 B를 포함하고 있다고 할 때에 A에서 B를 사용하기 위해서는 new 연산자에 의해서 객체를 생성하고 사용해야 한다.

만약 사용자에 요청에 의해서 A와 포함관계에 있는 B대신에 새로운 클래스 K로 변경 요청이 있다면 A클래스 내에 있는 new B() 대신에 new K()로 변경해야 할 것이다. 

이 때 B가 사용되던 곳이 A 한 곳이 아니라 여러 곳(수십 곳)이라면 일일이 찾아다니면서 수정하는 것은 번거로운 일이고 미처 수정하지 못한 부분도 있을 수 있다.

이러한 문제를 해결하기 위하여 스프링 DI는 사용자의 요청에 의해 수정이 될 것 같은 객체의 생성을 즉 new 연산자를 자바 소스 코드 내에서 걷어내고 스프링 컨테이너(환경설정파일)이 제공하는 것을 말한다.

빈번한 수정에 유연하게 대처할 수 있는 방법

- 강한 의존 관계 : 클래스 대 클래스 (클래스를 변수로 사용)
    
    ```java
    public class HelloTest {
    	public static void main(String[] args) {
    		// new MessageBean().sayHello("spring");
    		// 클래스를 사용하려면 반드시 new 연산자에 의해서 객체를 생성하고 사용할 수 있다.
    		
    		//고쳐야할 때 객체를 생성하는 부분을 변경해야 한다.
    		new MessageBeanKO().sayHello("spring");
    	}
    }
    ```
    
    수정이 어렵다
    
- 약한 의존 관계 : 클래스 대 인터페이스 (Interface)
    
    ```java
    public class HelloApp {
    	public static void main(String[] args) {
    		//MessageBean msg=new MessageBeanEn();
    		//msg.sayHello("spring");
    		
    		//변수의 타입을 바꾸지 않고 객체만 바꾸면 된다
    		//인터페이스를 사용한 수정
    		MessageBean msg=new MessageBeanKO();
    		msg.sayHello("spring");
    	}
    }
    ```
    
    클래스 변수를 사용할 때 보다 상대적으로 쉽다
    
    고칠 코드가 적어진다.
    
- 의존성 주입 : 스프링 컨테이너 사용
    
    [Maven Repository: org.springframework » spring-core » 3.1.1.RELEASE](https://mvnrepository.com/artifact/org.springframework/spring-core/3.1.1.RELEASE)
    
    [Maven Repository: org.springframework » spring-context » 3.1.1.RELEASE](https://mvnrepository.com/artifact/org.springframework/spring-context/3.1.1.RELEASE)
    
    스프링 환경설정 파일이 객체 생성에 필요한 일을 대신 해준다.
    
    스프링의 객체 제공자로서의 역할을 스프링 컨테이너라고 한다.
    
    ![Untitled](DAY61%20%E1%84%89%E1%85%B3%E1%84%91%E1%85%B3%E1%84%85%E1%85%B5%E1%86%BC%20beans%20b31d6743d5b740a3b9ddabbc77c5c4fc/Untitled.png)
    
    1. xml 파일 설정
        
        ```java
        <?xml version="1.0" encoding="UTF-8"?>
        <beans xmlns="http://www.springframework.org/schema/beans"
        	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
        
        	<bean id="mb" class="diTest03.MessageBeanKO"/>
        </beans>
        ```
        
    2. Hello App
        
        ```java
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;
        import org.springframework.core.io.FileSystemResource;
        import org.springframework.core.io.Resource;
        
        public class HelloApp {
        
        	public static void main(String[] args) {
        		ApplicationContext context=new ClassPathXmlApplicationContext("diTest03/beans.xml");
        		MessageBean bean=(MessageBean)context.getBean("mb");
        		bean.sayHello("spring");
        	}
        
        }
        ```
        
    
    ⚠️ 의존성 주입 시 주의사항
    
    자바의 기본 제공 생성자를 사용하기 때문에 만약 매개변수가 있는 생성자를 만들었다면 꼭 기본 생성자도 만들어주어야한다.
    

# 🌙 오후

---

## 의존관계에 있는 클래스 설정하기

### 1. 매개변수가 있는 생성자를 사용하여 객체를 생성하기

1. 포함관계 클래스 작성
    - 포함될 클래스
    
    ```java
    public class **MySqlArticleDAO** {
    	public void insert() {
    		System.out.println("추가하였습니다.");
    	}
    }
    ```
    
    - 포함할 클래스
    
    ```java
    public class **WriteArticleServiceImple** {
    	private MySqlArticleDAO dao;	//포함(has-a)관계
    	public WriteArticleServiceImple(MySqlArticleDAO dao) {
    		this.dao=dao;
    	}
    	public void pro() {
    		dao.insert();
    	}
    }
    ```
    
2. beans 설정
    
    ```java
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    	<bean id="dao" class="diTest05.MySqlArticleDAO"/>
    	<bean id="ws" class="diTest05.WriteArticleServiceImple">
    		**<constructor-arg>
    			<ref local="dao"/>
    		</constructor-arg>**
    	</bean>
    </beans>
    ```
    
    매개변수를 갖지 않는 생성자가 클래스에 없으므로 매개변수를 가지는 생성자를 사용하기 위해 <constructor-arg>태그를 사용하여 생성자에서 의존관계를 가질 수 있도록 한다.
    

1.  ws객체를 사용하는 main 메서드를 작성하여 결과를 확인해보자.
    
    ```java
    public class InsertTest {
    	ApplicationContext context = new ClassPathXmlApplicationContext("diTest05/beans.xml");
    	WriteArticleServiceImple article = (WriteArticleServiceImple)context.getBean("ws");
    }
    ```
    
    스프링 컨테이너가 제공하는 객체를 참조하기 위하여 `application context` 객체를 생성한다. 
    
    ⚠️ spring container가 아니라면
    
    `WriteArticleServiceImple`을 생성하기 전에 `MysqlArticleDAO`객체 생성 필요
    
    context를 통해서 스프링이 생성해주는 객체를 갖고 온다.
    

### 2. 생성자가 기본자료형을 전달받을때

1. `int` / `String`
    
    `<value>` 사용
    
    ```java
    public class SystemMonitor {
    	
    	private int periodTime;
    	
    	public SystemMonitor(int periodTime) {
    		this.periodTime=periodTime;
    	}
    	
    	public void monitor() {
    		System.out.println(periodTime+"분 간격으로 모니터링 합니다");
    	}
    }
    ```
    
    ```java
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    	<bean id="sm" class="diTest06.SystemMonitor">
    		<constructor-arg>
    			<value>10</value>
    		</constructor-arg>
    	</bean>
    </beans>
    ```
    
2. main
    
    ```java
    public class MonitoringTest {
    	public static void main(String[] args) {
    		ApplicationContext context=new ClassPathXmlApplicationContext("diTest06/beans.xml");
    		SystemMonitor sm=(SystemMonitor)context.getBean("sm");
    		sm.monitor();
    	}
    }
    ```
    

### 3. 생성자의 매개변수가 2개 이상

1. 생성자의 매개변수가 2개 이상인 클래스 생성
    
    ```java
    public class SystemMonitor {
    	private int periodTime;
    	private SMSSender sender;
    	
    	public SystemMonitor(int min,SMSSender sender) {
    		this.sender=sender;
    		this.periodTime=min;
    	}
    	
    	public void monitor() {
    		System.out.println(periodTime+"분 간격으로");
    		sender.send();
    		System.out.println("====================");
    	}
    	
    }
    ```
    
2. xml파일에 등록
    
    ```java
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    	<bean id="SMSSender" class="diTest07.SMSSender"/>
    	<bean id="sm" class="diTest07.SystemMonitor">
    		<constructor-arg value="10"/>
    		<constructor-arg ref="SMSSender"/>
    	</bean>
    </beans>
    
    ```
    
3. main 테스트
    
    ```java
    public class MonitorTest {
    	public static void main(String[] args) {
    		ApplicationContext context = new ClassPathXmlApplicationContext("diTest07/beans.xml");
    		SystemMonitor sm=(SystemMonitor) context.getBean("sm");
    		sm.monitor();
    	}
    }
    ```
    

### 4. 생성자 중복

1. 생성자가 여러개인 클래스 생성
    
    ```java
    public class Executor {
    	private Worker worker;
    	private String runner;
    	
    	public Executor(Worker worker) {
    		super();
    		this.worker = worker;
    		System.out.println("생성자1");
    	}
    	public Executor(String runner) {
    		super();
    		this.runner = runner;
    		System.out.println("생성자2");
    	}
    	public void execute() {
    		System.out.println("다음에 의해서 동작하였습니다.");
    		if (worker!=null) {
    			System.out.println(worker);
    		}else{
    			System.out.println(runner);
    		}
    	}
    }
    ```
    
2. 설정파일
    
    ```java
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    	
    	<bean id="worker" class="diTest08.Worker">
    		<constructor-arg value="spring"/>
    		<constructor-arg value="20"/>		
    	</bean>
    <!--  	<bean id="executor" class="diTest08.Executor">
    		<constructor-arg ref="worker"/>
    	</bean> -->
    	
    	<bean id="executor" class="diTest08.Executor">
    		<constructor-arg value="summer"/>
    	</bean>
    		
    </beans>
    ```
    

### 5. 생성자가 다양한 타입으로 중복일때(diTest09)

value는 기본적으로 String으로 처리되는 성격이 있다.

1. 클래스 생성
    
    ```java
    public class JobExecutor {
    	public JobExecutor(String name,int seconds) {
    		System.out.println("생성자 호출1");
    	}
    	public JobExecutor(String name, long miliseconds) {
    		System.out.println("생성자 호출2");
    	}
    	public JobExecutor(String name, String seconds) {
    		System.out.println("생성자 호출3");
    	}
    }
    ```
    
2. xml 파일
    
    ```java
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    	<bean id="job" class="diTest09.JobExecutor">
    		<constructor-arg value="spring"/>
    		<constructor-arg value="1000"/>
    	</bean>
    </beans>
    ```
    

이렇게 설정했을때 기본적으로 3번 생성자가 동작하고, 3번 생성자를 주석처리하면 입력값 1000을 분석해 int 자료형으로 받아서 2번 생성자를 호출한다.

특별하게 long 형으로 받고 싶다면 value에서 속성을 설정해준다.

⇒ `<constructor-arg value="1000" type="long"/>`

### 6. 프로퍼티 설정 방식(diTest10)

setter에 의해서 멤버에 접근하는 방식

`property` 속성을 사용한다

1. 객체를 사용하는 생성자
    
    ```java
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    	
    	<bean id="mySqlArticleDAO" class="diTest10.MySqlArticleDAO"/>
    	<bean id="ws" class="diTest10.WriteArticleServiceImple">
    		<property name="dao" ref="mySqlArticleDAO"></property>
    	</bean>
    
    </beans>
    ```
    

1. 기본자료형 생성자
    
    ```java
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    	<bean id="dataSource" class="diTest11.DataSource">
    		<property name="driver" value="driver"/>
    		<property name="url" value="url"/>
    		<property name="username" value="c##madang"/>
    		<property name="password" value="madang"/>
    		
    	</bean>
    </beans>
    ```