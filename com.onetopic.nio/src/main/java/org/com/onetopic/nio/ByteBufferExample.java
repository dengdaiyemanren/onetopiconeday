package org.com.onetopic.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * 演示 Buffer的Get 和set方式
 * @author Administrator
 *
 */
public class ByteBufferExample {

	byte array[] = new byte[1024];

	ByteBuffer buffer = ByteBuffer.wrap(array);

	public ByteBuffer put(byte b) {
		buffer.put(b);
		return buffer;
	}

	public ByteBuffer put(byte src[]) {
		buffer.put(src);
		return buffer;
	}

	public ByteBuffer put(byte src[], int offset, int length) {
		buffer.put(src, offset, length);
		return buffer;
	}

	public ByteBuffer put(ByteBuffer src) {
		buffer.put(src);
		return buffer;
	}

	public ByteBuffer put(int index, byte b) {
		buffer.put(index, b);
		return buffer;
	}

	public byte get() {
		return buffer.get();
	}

	ByteBuffer get(byte dst[]) {
	
		return buffer.get(dst);
	}

	ByteBuffer get(byte dst[], int offset, int length) {
		return buffer.get(dst, offset, length);
	}

	byte get(int index) {
		return buffer.get(index);
	}
	
	ByteBuffer slice(int pos,int limit)
	{
		buffer.position(pos);
		buffer.limit(limit);
		ByteBuffer slice = buffer.slice().asReadOnlyBuffer();
		
		return slice;
	}
	
	public CharBuffer decode() throws CharacterCodingException
	{
		Charset latin1 = Charset.forName("ISO-8859-1");
		CharsetDecoder decoder = latin1.newDecoder();
	
		CharBuffer charBuffer = decoder.decode(this.buffer.asReadOnlyBuffer());
		
		return charBuffer;
	}
	
	public void enCode(CharBuffer cb) throws CharacterCodingException
	{
		Charset latin1 = Charset.forName( "ISO-8859-1" );
		CharsetEncoder encoder = latin1.newEncoder();
	
		ByteBuffer bb = encoder.encode(cb.asReadOnlyBuffer());
		
		buffer.put(bb);
		
	}
}
