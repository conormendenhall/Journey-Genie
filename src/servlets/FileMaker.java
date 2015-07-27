package servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMaker {

	public static boolean makeFile(String s) throws IOException {
		String fileString = s;
		Path filePath = Paths.get(fileString);
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
			return true;
		}
		return false;
	}


}