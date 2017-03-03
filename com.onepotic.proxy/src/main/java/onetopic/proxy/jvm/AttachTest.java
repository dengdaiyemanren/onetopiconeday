package onetopic.proxy.jvm;

import java.io.IOException;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

public class AttachTest {
	
	public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
		VirtualMachine vm = VirtualMachine.attach(args[0]);
		vm.loadAgent("JvmAgent.class");
		

	}

}
