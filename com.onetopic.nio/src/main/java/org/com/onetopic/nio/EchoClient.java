package org.com.onetopic.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class EchoClient {

	public void connectServerAndSend(String server, int port, String word) throws IOException {
		// 创建一个套接字通道，注意这里必须使用无参形式
		SocketChannel sc = SocketChannel.open();

		// 设置为非阻塞模式，
		// 这个方法必须在实际连接之前调用(所以open的时候不能提供服务器地址，否则会自动连接)
		sc.configureBlocking(false);
		
		// 连接服务器，由于是非阻塞模式，这个方法会发起连接请求，
		// 并直接返回false(阻塞模式是一直等到链接成功并返回是否成功)
		if (!sc.connect(new InetSocketAddress(server, port))) {
			while (!sc.finishConnect()) {
				System.out.print("not finishConnect");
			}
		}
		byte [] bufferW = word.getBytes();
		ByteBuffer bbW = ByteBuffer.wrap(bufferW);
		
		ByteBuffer bbR = ByteBuffer.allocate(bufferW.length);
		
		int rcvSize = 0;
		int byteRcv;
		while (rcvSize < bufferW.length) {
			
			if (bbW.hasRemaining()) {
				sc.write(bbW);
			}
			
			if ((byteRcv = sc.read(bbR)) == -1) {
				throw new SocketException("Connection closed prematurely");
			}
			
			rcvSize += byteRcv;
			
			System.out.println("send one");
		}
		
		System.out.println("Received:" + new String(bbR.array(), 0, rcvSize));
		
		sc.close();
		

	}

	public static void main(String args[]) throws Exception {
		if ((args.length < 2) || (args.length > 3))// Testforcorrect#ofargs
			throw new IllegalArgumentException("Parameter(s): < Server> < Word> [< Port>]");
		String server = args[0];// 服务器IP地址或名字
		byte[] argument = args[1].getBytes();// 向服务器发送的字符串
		int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7777;
		SocketChannel clntChan = SocketChannel.open();

		// 连接服务器，由于是非阻塞模式，这个方法会发起连接请求，
		// 并直接返回false(阻塞模式是一直等到链接成功并返回是否成功)
		if (!clntChan.connect(new InetSocketAddress(server, servPort))) {
			while (!clntChan.finishConnect()) {
				System.out.print("write111");
			}
		}
		ByteBuffer writeBuf = ByteBuffer.wrap(argument);
		ByteBuffer readBuf = ByteBuffer.allocate(argument.length);
		int totalBytesRcvd = 0;
		int bytesRcvd;
		while (totalBytesRcvd < argument.length) {
			if (writeBuf.hasRemaining()) {
				clntChan.write(writeBuf);
			}
			if ((bytesRcvd = clntChan.read(readBuf)) == -1) {
				throw new SocketException("Connection closed prematurely");
			}
			totalBytesRcvd += bytesRcvd;
			System.out.print(".");
		}

		System.out.println("Received:" + new String(readBuf.array(), 0, totalBytesRcvd));
		clntChan.close();

	}
}