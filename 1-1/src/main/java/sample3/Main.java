package sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext
							("sample3/beans.xml");
		Human human= (Sato)ctx.getBean("sato");
		human.has(); //--->입니다. 다음의 상품을 가지고 있습니다.
		human= (Danaka)ctx.getBean("danaka");
		human.has();
		human= (Gobayashi)ctx.getBean("gobayashi");
		human.has();
	}
}
