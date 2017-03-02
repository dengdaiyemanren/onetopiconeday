package onetopic.proxy.cglib.demo;

import org.junit.Test;


public class ProxyCglibTest {
	@Test
	public void testProxy() throws Throwable {
		// 实例化目标对象
		UserServiceImpl userService = new UserServiceImpl();
		
		// 实例化InvocationHandler
		MyMethodInterceptor invocationHandler = new MyMethodInterceptor(userService);
		
		// 根据目标对象生成代理对象
		UserServiceImpl proxy = (UserServiceImpl) invocationHandler.getProxy();
		
		// 调用代理对象的方法
		proxy.add();
		
	}
}
