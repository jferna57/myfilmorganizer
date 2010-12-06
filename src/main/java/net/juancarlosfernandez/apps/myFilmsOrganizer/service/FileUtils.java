package net.juancarlosfernandez.apps.myFilmsOrganizer.service;

import java.io.File;
import java.io.IOException;

public class FileUtils {

	/**
	 * Delete all files in a non-empty directory
	 * 
	 * @param path
	 * @return
	 */
	static public boolean deleteDirectory(File path) {
		if (path.exists()) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
				}
			}
		}
		return (path.delete());
	}
	
	static public boolean createFiles(String pathName, String[] fileName) throws IOException {
		
		File path = new File(pathName);
		
		if (path.exists()){
			for (int i=0; i< fileName.length; i++) {
				File fileNamePath = new File(pathName+fileName[i]);
				fileNamePath.createNewFile();
			}
		} else
			return false;
		
		return true;
	}
}
