package onetopic.proxy.javassist.demo;

import org.junit.Test;

public class ProxyJavaassistTest {
	@Test
	public void testProxy() throws Throwable {
		// 实例化目标对象
		UserService userService = new UserServiceImpl();
		
		// 实例化InvocationHandler
		MyMethodHandler invocationHandler = new MyMethodHandler(userService);
		
		// 根据目标对象生成代理对象
		UserService proxy = (UserService) invocationHandler.getProxy();
		
		// 调用代理对象的方法
		proxy.add();
		
	}
}
