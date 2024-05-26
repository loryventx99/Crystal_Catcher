package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class provides utility methods for file operations related to a specific file that manages money count.
 *
 * @author Lorenzo Venturino
 * @version 1.0
 */
public class FileOperations {
	private static final File FILE = new File(GetPath.FILE);

	/**
	 * Sets the count in the file.
	 *
	 * @param count The new count to be set.
	 */
	public static void setCount(int count) {
		try {
			FileWriter fw = new FileWriter(FILE);
			fw.write(Integer.toString(count));
			fw.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Adds the given count to the existing count in the file.
	 *
	 * @param count The count to be added.
	 */
	public static void addCount(int count) {
		int oldCount = getCount();
		setCount(oldCount + count);
	}

	/**
	 * Retrieves the count from the file.
	 *
	 * @return The count from the file.
	 */
	public static int getCount() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILE));
			int count = Integer.parseInt(br.readLine());
			br.close();

			return count;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}