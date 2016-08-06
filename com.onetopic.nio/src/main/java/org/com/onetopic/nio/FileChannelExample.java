package org.com.onetopic.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 演示read and write by channel,buffer 方法
 * 
 * @author yinlg
 *
 */
public class FileChannelExample {

	/**
	 * @param sourceFile
	 *            源文件路径
	 * @param destFile
	 *            目的文件路径
	 * @return
	 * @throws IOException
	 */
	public void readAndWrite(String sourceFile, String destFile) throws IOException {
		FileInputStream fin = null;
		FileOutputStream fout = null;
		try {
			String infile = sourceFile;
			String outfile = destFile;

			fin = new FileInputStream(infile);
			fout = new FileOutputStream(outfile);

			FileChannel fcin = fin.getChannel();
			FileChannel fcout = fout.getChannel();

			// ByteBuffer buffer = ByteBuffer.allocate(1024);
			// 直接缓冲区
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

			while (true) {
				buffer.clear();

				int r = fcin.read(buffer);

				if (r == -1) {
					break;
				}

				// flip方法将Buffer从写模式切换到读模式。
				buffer.flip();

				fcout.write(buffer);
			}

		} catch (FileNotFoundException ex1) {
			throw ex1;

		} catch (IOException ex2) {
			throw ex2;

		} finally {
			FileUtil.closeInput(fin);
			FileUtil.closeOutPut(fout);
		}
	}

	/**
	 *  内存读,将文件映射到内存
	 * @param sourceFile
	 * @param pos
	 * @param len
	 * @return
	 * @throws IOException
	 */
	public MappedByteBuffer readFileToMemory(String sourceFile, int pos, int len) throws IOException
	{
		MappedByteBuffer mbb = null;

		FileInputStream fin = null;

		String infile = sourceFile;

		try {
			fin = new FileInputStream(infile);

			FileChannel fcin = fin.getChannel();

			mbb = fcin.map(FileChannel.MapMode.READ_ONLY, pos, len);
			
		} catch (IOException ex) {
			throw ex;
		} finally {
			FileUtil.closeInput(fin);
		}

		return mbb;
	}

}
