package net.juancarlosfernandez.apps.myFilmsOrganizer.utils;

import java.io.File;

import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.OrFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class FilmSearcher {
	
	/**
	 * Get all the files (films) in a path directory. Films are files with .avi or .mpeg extension.
	 * Do not find films in subdirectories.
	 * @param path Directory path
	 * @return All the files of films
	 */
	public String[] getFilms(String path) {

		File dir = new File(path);
		// String[] files = dir.list(FileFileFilter.FILE);

		String[] files = dir.list(
				new AndFileFilter(
						new OrFileFilter(
								new SuffixFileFilter(".avi"), 
								new SuffixFileFilter(".mpeg")
						),
						new NotFileFilter(FileFilterUtils.directoryFileFilter())
				));

		return files;
	}
	
	public boolean normalizeFilmName(String path, String fileName) {
		
		File film = new File(path+fileName);

		String fileNameNormalize = fileName.toLowerCase();
		// fileNameNormalize = fileName.replaceAll("[dvdrip|spanish| ]", "");
		
		// Create the new file
		File filmNormalize = new File(path+fileNameNormalize);
		film.renameTo(filmNormalize);
		
		return true;
	}

}
