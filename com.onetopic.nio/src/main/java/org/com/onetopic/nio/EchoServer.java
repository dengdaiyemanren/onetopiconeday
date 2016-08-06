package org.com.onetopic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class EchoServer {

	private int ports[];
	private ByteBuffer echoBuffer = ByteBuffer.allocate(1024);

	// Create a new selector
	private Selector selector = Selector.open();

	public EchoServer(int ports[]) throws IOException {
		this.ports = ports;
	}

	public void server() throws IOException {

		// Open a listener on each port, and register each one
		// with the selector
		for (int i = 0; i < ports.length; ++i) {
			ServerSocketChannel ssc = ServerSocketChannel.open();

			// 配置为非阻塞模式
			ssc.configureBlocking(false);

			ServerSocket ss = ssc.socket();
			InetSocketAddress address = new InetSocketAddress(ports[i]);
			ss.bind(address);

			ssc.register(selector, SelectionKey.OP_ACCEPT);

			System.out.println("Going to listen on " + ports[i]);
		}

	}

	public void accept(SelectionKey key) throws IOException {

		// Accept the new connection
		ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
		SocketChannel sc = ssc.accept();
		sc.configureBlocking(false);

		// Add the new connection to the selector
		sc.register(selector, SelectionKey.OP_READ);

		System.out.println("Got connection from " + sc);
	}

	public int readAndWriteBack(SelectionKey key) throws IOException {
		// Read the data
		SocketChannel sc = (SocketChannel) key.channel();

		// Echo data
		int bytesEchoed = 0;
		while (true) {
			echoBuffer.clear();

			// 写到buffer
			int r = sc.read(echoBuffer);

			if (r <= 0) {
				break;
			}

			echoBuffer.flip();

			// 读到buffer
			sc.write(echoBuffer);

			bytesEchoed += r;
		}

		System.out.println("Echoed " + bytesEchoed + " from " + sc);

		sc.close();

		return bytesEchoed;

	}

	public void client() throws IOException {

		while (true) {
			selector.select();
			Set selectedKeys = selector.selectedKeys();

			Iterator it = selectedKeys.iterator();

			while (it.hasNext()) {
				SelectionKey key = (SelectionKey) it.next();

				if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
					accept(key);
					it.remove();

				} else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {

					readAndWriteBack(key);
					it.remove();
				}

			}

		}
	}
}
