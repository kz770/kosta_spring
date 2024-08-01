# DAY62 : 스프링 MVC패턴

date: August 1, 2024
subject: java, spring
공부한 곳: KOSTA

# 🐾 **T I L 240801 (ฅ•.•ฅ)**

✅ 의존관계 자동 설정

✅ 스트럿츠 방식과 스프링방식

✅ 스프링 MVC패턴의 구성요소

✅ POJO 방식 컨트롤러 생성

# ☀ 오전

---

어플리케이션에게 DeptDAO 객체를 생성해주는 스프링 환경설정 파일을 만들고 그것을 이용하는 메인 메서드를 작성하여 결과를 확인하기

bean 팩토리를 사용하긴 번거로움

이걸 한 줄로 할 수 있도록(쉽게 객체를 만들 수 있도록) 만들어놓은것이 후손인 application context

## XML 네임스페이스를 이용한 프로퍼티 설정

자식 노드를 따로 생성하지 않고 P라는 접두어를 이용한다

- 기존
    
    ```java
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    	<bean id="SMSSender" class="exam03.SMSSender"/>
    	<bean id="systemMonitor" class="exam03.SystemMonitor">
    		<property name="periodTime" value="10"/>
    		<property name="sender" value="SMSSender"/>
    	</bean>
    	
    </beans>
    ```
    
- 네임스페이스 사용
    
    ```java
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
    	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    	xmlns:p="http://www.springframework.org/schema/p"
    	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    	<bean id="SMSSender" class="exam03.SMSSender"/>
    	<bean id="systemMonitor" class="exam03.SystemMonitor"
    		p:periodTime="10"
    		p:sender-ref="SMSSender"/>
    	
    </beans>
    ```
    

## 식별값을 갖지 않는 Bean 객체 전달

멤버변수로 존재하는 클래스를 먼저 생성하지 않을 수 있다.

```java
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="dao" class="exam04.DeptDAO">
		<property name="deptVO">
			<bean class="exam04.DeptVO">
				<property name="dloc" value="종각"></property>
				<property name="dname" value="개발1팀"></property>
				<property name="dno" value="10"></property>
			</bean>
		</property>
	</bean>
</beans>
```

이미 있는 VO객체를 참조하지 않고 property 안에서 VO를 직접 생성한다.

VO의 bean을 생성할 때는 id, 즉 식별자를 갖지 않아도 된다.

## 컬렉션 타입을 입력 받기 위한 스프링 태그

```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="zipFilter" class="exam05.ZipFilter"></bean>
	<bean id="encryptionFilter" class="exam05.EncryptionFilter"></bean>
	<bean id="ph" class="exam05.ProtocolHandler">
		<property name="filters">
			<list>
				<ref local="encryptionFilter" />
				<ref local="zipFilter" />
				<bean class="exam05.HeaderFilter"/>
			</list>
		</property>
	</bean>
</beans>
```

## 의존관계 자동설정

의존관계가 복잡하거나 많아지게 되면 설정파일도 그만큼 복잡해진다.

| byName | 프로퍼티 이름으로 의존관계 자동 설정 |
| --- | --- |
| byType | 프로퍼티 타입으로 의존관계 자동 설정 |
| Contructor | 생성자에 의한 자동설정 |
| autodetect | 생성자를 먼저 적용하고, byType에 의한 설정 |
1. byName
    
    ```java
    	<bean id="dao" class="exam06.MySqlArticleDAO"></bean>
    	<bean id="ws" class="exam06.WriteArticleServiceImple"
    		autowire="byName"/>
    ```
    
    ws 클래스에서 설정한 멤버변수의 이름과 똑같은 객체를 생성한다!
    
2. byType
    
    ```java
    	<bean id="mySqlArticleDAO" class="exam07.MySqlArticleDAO"></bean>
    	<bean id="ws" class="exam07.WriteArticleServiceImple"
    		autowire="byType"/>
    ```
    
    type이 unique해야한다.
    

## Bean 범위설정

```java
	<bean id="kim" class="exam08.Person"
	p:name="spring"
	p:age="20"
	scope="prototype"/>
```

scope의 default는 singleton이고, 모든 객체가 같은 주소값을 가리킨다.

prototype으로 설정해주면 getBean에서 생성자가 요청되고 모두 다른 객체가 된다.

## 어노테이션 기반 객체생성

@Configuration

@Bean

```java
@Configuration
public class SpringConfig {
	
	@Bean
	public Person kim() {
		Person p = new Person();
		p.setName("spring");
		p.setAge(20);
		return p;
	}
}
```

메서드 이름 kim이 xml 설정파일의 id와 같다.

```java
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
		Person p=(Person)context.getBean("kim");
		System.out.println(p);
	}
```

## component scan

1. XML 기반의 자동연결 방식
    
    ```xml
    <context:component-scan base-package="exam11"/>
    ```
    
    ### 클래스 마크
    
    - `@Component` : 어떤 특정한 역할에 속하지 않은 클래스
    - `@Repository` : 저장소 역할을 하는 클래스(ex. dao)
    
    base 패키지를 설정하면 어노테이션 마크가 있는 자동으로 스캔해서 객체를 생성해준다.
    
    ```java
    @Component
    public class MySqlArticleDAO {
    	public void insert() {
    		System.out.println("추가하였습니다.");
    	}
    }
    ```
    
    ⚠️ 특별히 이름을 지정하지 않으면 첫글자만 소문자로 바꿔서 지정된다.
    
    ### 객체 연결
    
    - `@Autowired`
        
        ```java
        @Component("ws")
        public class WriteArticleServiceImple {
        	@Autowired
        	private MySqlArticleDAO dao;	//포함(has-a)관계
        	public void setDao(MySqlArticleDAO dao) {
        		this.dao = dao;
        	}
        	public void pro() {
        		dao.insert();
        	}
        }
        
        ```
        

1. 어노테이션 기반
    
    ```java
    @Configuration
    @ComponentScan(basePackages="exam12")
    public class SpringConfiguration {	
    }
    ```
    

# 🌙 오후

---

## MVC패턴의 웹 어플리케이션 만들기

### 💫 Spring MVC의 구성요소

| 역할 | spring | 스트럿츠 |
| --- | --- | --- |
| 사용자 요청 처리→ model, view | controller | action |
| 사용자 요청 | dispatcher servlet | front controller |
| 요청에 해당하는 컨트롤러 검색 | handler  mapping | properties |
| view의 prefix와 subfix 설정 | view resolver |  |

⚠️ lib 꼭 import 먼저 하기

### 스프링의 컨트롤러 인터페이스 상속

1. web.xml
    
    ```java
      <servlet>
      	<servlet-name>kosta</servlet-name>
      	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
      </servlet>
      
      <servlet-mapping>
      	<servlet-name>kosta</servlet-name>
      	<url-pattern>*.do</url-pattern>
      </servlet-mapping>
    ```
    
    스프링은 어플리케이션에 필요한 파일을 환경설정에서 제공해준다.
    
    WEB-INF에서 servlet_name-servlet.xml을 환경설정 파일로 찾는다.
    
2. Contoller
3. kosta(servlet name)-servlet.xml
    
    ```java
    <!-- 핸들러 컨트롤러 객체를 생성하는 문장 -->
    	<bean id="helloController" class="com.kosta.controller.HelloController"/>
    	
    	<!-- 핸들러 매핑 (simple url handler mapping)-->
    	<bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
    		<!-- name에 mapping 정보를 저장  -->
    		<property name="mappings">
    			<props>
    				<prop key="/hello.do">helloController</prop>
    			</props>
    		</property>
    	</bean>
    ```
    

### POJO : Plain Old Java Object

어노테이션을 사용하여 프레임워크에 의존하지 않는 방식

- **프레임워크 의존적**
    
    옛날 방식의 스프링에서는 컨트롤러로 만들기 위해서는 스프링이 제공하는 컨트롤러 인터페이스를 구현해야하고, 그 인터페이스의 추상메서드인 handle request를 오버라이딩 해야만 했다.
    

- **POJO 방식**
    
    현재의 스프링에서는 프레임워크에 의존하지 않고 특정 인터페이스를 구현할 필요도 없이 메서드 이름도 자유롭게 원래 자바 클래스 만들듯이 작성하여 컨트롤러를 만들 수 있다.
    

1. web.xml
    
    ```java
      <servlet>
      	<servlet-name>kosta</servlet-name>
      	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
      </servlet>
      
      <servlet-mapping>
      	<servlet-name>kosta</servlet-name>
      	<url-pattern>*.do</url-pattern>
      </servlet-mapping>
    ```
    
    서블릿 매핑
    
2. kosta-servlet
    
    **생성**
    
3. controller
    
    ```java
    @Controller
    public class HelloController {
    	@RequestMapping("/hello.do")
    	public ModelAndView hello() {
    		ModelAndView mav=new ModelAndView();
    		mav.addObject("msg","hello 스프링");
    		mav.setViewName("hello");
    		return mav;
    	}
    }
    ```
    
    **어노테이션**
    
4. kosta-servlet
    
    `xmlns:context="http://www.springframework.org/schema/context"`
    
    ```java
    	<context:component-scan base-package="day0801_mvcTest02"/>
    	
    	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    		<property name="prefix" value="/WEB-INF/views/"/>
    		<property name="suffix" value=".jsp"/>
    	</bean>
    ```