package onetopic.proxy.jvm;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class JvmInterceptor implements ClassFileTransformer{

	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
			ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		
		try {
			CtClass ctClass= ClassPool.getDefault().get(className.replace('/','.'));
			
			CtMethod sayHelloMethod=ctClass.getDeclaredMethod("add");
		
			sayHelloMethod.insertBefore("System.out.println(\"before sayHello----\");");

            sayHelloMethod.insertAfter("System.out.println(\"after sayHello----\");");
		
            return ctClass.toBytecode();
		
		
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotCompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return classfileBuffer;
		
	}

	
}
