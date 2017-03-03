package onetopic.proxy.javassist.demo;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtNewMethod;
import javassist.NotFoundException;

public class ByteCodeProxy {

	
	public Object createMethod(Object delegate,String[] methods) throws CannotCompileException, InstantiationException, IllegalAccessException, NotFoundException
	{
		ClassPool mPool = new ClassPool(true);
		CtClass mCtc = mPool.makeClass(delegate.getClass().getName() + "JavaassistProxy");  
		Class [] interfaceArray= delegate.getClass().getInterfaces();
		
		//添加接口
		for(int i = 0;i<interfaceArray.length;i++)
		{
			mCtc.addInterface(mPool.get(interfaceArray[i].getName()));
		}
		
		for(int i = 0 ;i<methods.length;i++)
		{
			//添加方法
			mCtc.addMethod(CtNewMethod.make(methods[i], mCtc));
			
		}
		
		Class pc = mCtc.toClass();
		
		Object bytecodeProxy =  pc.newInstance();
		
		return bytecodeProxy;
		
	}
	

	
}
