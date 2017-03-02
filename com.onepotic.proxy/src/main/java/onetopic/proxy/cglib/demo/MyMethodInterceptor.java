package onetopic.proxy.cglib.demo;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyMethodInterceptor implements MethodInterceptor{

	
	// 目标对象 
	private Object target;
	
	/**
	 * 构造方法
	 * @param target 目标对象 
	 */
	public MyMethodInterceptor(Object target) {
		super();
		this.target = target;
	}
	
	public Object intercept(Object obj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable {
		
		// 在目标对象的方法执行之前简单的打印一下
		System.out.println("------------------before------------------");
		
		Object result =  methodProxy.invokeSuper(obj, arg);
		
		// 在目标对象的方法执行之后简单的打印一下
		System.out.println("-------------------after------------------");
			
		return result;
	}
	
	/**
	 * 获取目标对象的代理对象
	 * @return 代理对象
	 */
	public Object getProxy() {
		
		 Enhancer enhancer = new Enhancer();
	     enhancer.setSuperclass(target.getClass());
	     enhancer.setCallback(this);
	     
	     return enhancer.create();
	}
	

}
