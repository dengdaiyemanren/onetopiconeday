package org.com.onetopic.nio;

import java.io.IOException;

import org.junit.Test;

public class EchoClientTest {
	@Test
	public void send() throws IOException 
	{
		EchoClient client = new EchoClient();
		
		String sendStr = "777777";
		client.connectServerAndSend("127.0.0.1", 11111, sendStr);
		
	}
}
