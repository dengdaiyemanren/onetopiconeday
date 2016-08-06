package org.com.onetopic.nio;

import java.io.IOException;

import org.junit.Test;

public class EchoServerTest {

	@Test
	public void echo() throws IOException {
		int ports[] = new int[2];

		ports[0] = 11111;
		ports[1] = 11112;

		EchoServer sc = new EchoServer(ports);

		sc.server();
		sc.client();
	}
}
