package onetopic.proxy.jvm;

import java.lang.instrument.Instrumentation;

public class JvmAgent {

	public static void premain(String agentArgs,Instrumentation inst){

        //加入ClassFileTransfomer
        inst.addTransformer(new JvmInterceptor());
        
    }
	
}
