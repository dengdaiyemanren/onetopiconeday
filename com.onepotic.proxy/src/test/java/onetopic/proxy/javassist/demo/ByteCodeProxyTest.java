package onetopic.proxy.javassist.demo;

import org.junit.Test;

import javassist.CannotCompileException;
import javassist.NotFoundException;

public class ByteCodeProxyTest {

	@Test
	public void add() throws InstantiationException, IllegalAccessException, CannotCompileException, NotFoundException
	{
		ByteCodeProxy byteCodeProxy = new ByteCodeProxy();
		UserService2 userService = new UserServiceImpl();
		String methodStr = "public void add() {System.out.println(\"--------------------adddd1---------------\");}";
		String methodStr2 = "public void add2() {System.out.println(\"--------------------adddd2---------------\");}";
		String methodArray[] = new String[]{methodStr,methodStr2};
		userService = (UserService2) byteCodeProxy.createMethod(userService, methodArray);
		
		userService.add2();
	}
}
