package onetopic.proxy.javassist.demo;

import java.lang.reflect.Method;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

public class MyMethodHandler implements MethodHandler{

	// 目标对象 
	private Object target;
	
	/**
	 * 构造方法
	 * @param target 目标对象 
	 */
	public MyMethodHandler(Object target) {
		super();
		this.target = target;
	}
	
	public Object invoke(Object arg0, Method arg1, Method method, Object[] arg3) throws Throwable {
		
		// 在目标对象的方法执行之前简单的打印一下
		System.out.println("------------------before------------------");
		
		Object obj = method.invoke(arg0, arg3);
		
		// 在目标对象的方法执行之后简单的打印一下
		System.out.println("-------------------after------------------");
			
		
		return obj;
		 
	}
	
	/**
	 * 获取目标对象的代理对象
	 * @return 代理对象
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Object getProxy() throws InstantiationException, IllegalAccessException {
		
		  ProxyFactory factory=new ProxyFactory();
		//设置父类，ProxyFactory将会动态生成一个类，继承该父类  
	     factory.setSuperclass(target.getClass()); 
	     
	     factory.setFilter(new MethodFilter() {  
	            public boolean isHandled(Method m) {  
	            	/*if(m.getName().equals("add")){  
	                    return true;  
	                } */ 
	                return true;
	            }  
	        });  
	     factory.setHandler(this);
	     
	     Class<?> c=factory.createClass(); 
	     
	     Object obj = c.newInstance();
	     
	     /*Method [] methods= new Method[obj.getClass().getMethods().length];
	     
	     methods =obj.getClass().getMethods();
	     
	     for(int i = 0; i<methods.length;i++)
	     {
	    	 System.out.println(methods[i].getName());
	     }*/
	     
	     return  obj;
	     
	}
}
