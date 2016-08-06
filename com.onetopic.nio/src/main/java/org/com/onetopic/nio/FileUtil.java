package org.com.onetopic.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

	public static void closeInput(FileInputStream... inputs) {

		for (FileInputStream input : inputs) {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void closeOutPut(FileOutputStream... outputs) {

		for (FileOutputStream output : outputs) {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
