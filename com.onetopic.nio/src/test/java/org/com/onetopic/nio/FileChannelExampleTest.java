package org.com.onetopic.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import org.junit.Test;

public class FileChannelExampleTest {

	@Test(expected = FileNotFoundException.class)
	public void readAndWrite_fileNotFound() throws IOException {
		String sourceFile = "";
		String destFile = "";
		new FileChannelExample().readAndWrite(sourceFile, destFile);
	}

	@Test
	public void readAndWrite_normal() throws IOException {
		String sourceFile = this.getClass().getResource("input/").getPath() + "testinput.txt";

		// System.out.println(sourceFile);

		String destFile = this.getClass().getResource("output/").getPath() + "output.txt";
		new FileChannelExample().readAndWrite(sourceFile, destFile);
	}

	@Test
	public void readFileToMemory() throws IOException {
		String sourceFile = this.getClass().getResource("input/").getPath() + "testinput.txt";
		MappedByteBuffer result = new FileChannelExample().readFileToMemory(sourceFile, 0, 4);

		Charset latin1 = Charset.forName("ISO-8859-1");
		CharsetDecoder decoder = latin1.newDecoder();

		CharBuffer cb = decoder.decode(result);

		System.out.println(cb.toString());

	}

}
