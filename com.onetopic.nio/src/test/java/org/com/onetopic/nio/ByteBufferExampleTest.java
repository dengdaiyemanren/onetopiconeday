package org.com.onetopic.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;

import org.junit.Assert;
import org.junit.Test;

public class ByteBufferExampleTest {
	
	@Test
	public void getAndSet_PutNoIndex()
	{
		ByteBufferExample buffer = new ByteBufferExample();
		buffer.put((byte)'a');
		buffer.put("b".getBytes());
		buffer.put((byte)'c');//pos  move
		byte array[] = new byte[10];
		array[0] = 'd';
		array[1] = 'e';
		buffer.put(array,0,1);
		
		byte destArry[] = new byte[1024];
		destArry[0]='a';
		destArry[1]='b';
		destArry[2]='c';
		destArry[3]='d';
		//destArry[4]='e';
		byte destArryReturn[] = new byte[1024];
		
		buffer.buffer.flip();
		buffer.buffer.clear();
		buffer.get(destArryReturn);
		Assert.assertArrayEquals(destArry,destArryReturn);
		
	}
	@Test
	public void getAndSet_PutIndex()
	{
		ByteBufferExample buffer = new ByteBufferExample();
		buffer.put((byte)'a');
		buffer.put("b".getBytes());
		buffer.put(2,(byte)'c');//pos not move
		byte array[] = new byte[10];
		array[0] = 'd';
		array[1] = 'e';
		buffer.put(array,0,2);
		
		byte destArry[] = new byte[4];
		destArry[0]='a';
		destArry[1]='b';
		destArry[2]='d';
		destArry[3]='e';
		//destArry[4]='f';
		byte destArryReturn[] = new byte[4];
		
		buffer.buffer.flip();
		//System.out.println(buffer.buffer.remaining());
		buffer.get(destArryReturn);
		//System.out.println(buffer.buffer.remaining());
		
		
		Assert.assertArrayEquals(destArry,destArryReturn);
	}
	
	@Test
	public void silce()
	{
		ByteBufferExample buffer = new ByteBufferExample();
		buffer.put((byte)'a');
		buffer.put("b".getBytes());
		buffer.put((byte)'c');
		buffer.put((byte)'d');
		
		ByteBuffer subBuffer = buffer.slice(0, 1);
		
		while(subBuffer.hasRemaining())
		{
			//System.out.println(subBuffer.get());
		}
		
		while(buffer.buffer.hasRemaining())
		{
			//System.out.println(buffer.get());
		}
	}
	
	@Test
	public void enCode() throws CharacterCodingException
	{
		ByteBufferExample buffer = new ByteBufferExample();

		char destArry[] = new char[1];
		
		destArry[0] = 'a';
		
		CharBuffer cb =  CharBuffer.wrap(destArry);
		
		buffer.enCode(cb);
		buffer.buffer.flip();
		
		String aa = buffer.decode().toString();
		
		Assert.assertEquals("a", aa);
		
	}
	
	@Test
	public void deCode() throws CharacterCodingException
	{
		ByteBufferExample buffer = new ByteBufferExample();
		buffer.put((byte)'a');
		buffer.put("b".getBytes());
		buffer.put((byte)'c');
		buffer.put((byte)'d');
		
		buffer.buffer.flip();
		
		CharBuffer cb = buffer.decode();
		
		//System.out.println(cb.toString());
		Assert.assertEquals("abcd", cb.toString());
	}
	
	

}
