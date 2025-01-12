package hello.core.scope;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

class PrototypeTest {

	@Test
	@DisplayName("display_name_value")
	void prototypeBeanFind() {
		// AnnotationConfig ... 에서 컴포넌트(PrototypeBean.class)를 넣어서 컨테이너에 등록
		// 직접 넣으면 컴포넌트처럼 컨테이너에 등록된다.
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
		System.out.println("find prototypeBean1");
		PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
		System.out.println("find prototypeBean2");
		PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
		System.out.println("prototypeBean1 = " + prototypeBean1);
		System.out.println("prototypeBean2 = " + prototypeBean2);

		assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
		ac.close(); // 종료 메서드가 호출되지 않는다.
	}

	@Scope("prototype")
	static class PrototypeBean {

		@PostConstruct
		public void init() {
			System.out.println("SingletonBean.init");
		}

		@PreDestroy
		public void destroy() {
			System.out.println("SingletonBean.destroy");
		}
	}
}
