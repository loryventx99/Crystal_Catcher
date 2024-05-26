package tester;

import util.FileOperations;

public class TesterFile {
	public static void main(String[] args) {
		System.out.println(FileOperations.getCount());
		FileOperations.addCount(2);
		System.out.println(FileOperations.getCount());
	}
}