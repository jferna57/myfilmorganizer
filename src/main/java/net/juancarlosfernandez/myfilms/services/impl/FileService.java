package net.juancarlosfernandez.myfilms.services.impl;

import java.io.File;
import java.io.IOException;

import net.juancarlosfernandez.myfilms.domain.Film;
import net.juancarlosfernandez.myfilms.services.IFileService;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AndFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.OrFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class FileService implements IFileService {

	/**
	 * Get all the files (films) in a path directory. Films are files with .avi
	 * or .mpeg extension. Do not find films in subdirectories.
	 * 
	 * @param path
	 *            Directory path
	 * @return All the files of films
	 */
	public Film[] getFilms(String path) {

		File dir = new File(path);
		// String[] files = dir.list(FileFileFilter.FILE);

		String[] files = null;

		if (dir.exists()) {
			files = dir.list(new AndFileFilter(
					new OrFileFilter(new SuffixFileFilter(".avi"),
							new SuffixFileFilter(".mpeg")), new NotFileFilter(
							FileFilterUtils.directoryFileFilter())));
		}

		Film[] films = null;

		if (files.length > 0) {
			
			films = new Film[files.length];

			for (int i = 0; i < files.length; i++) {
				films[i] = new Film();
				// films[i].setIdFilm(getChecksum(path, filename));
				films[i].setFilename(files[i]);
				films[i].setLocation(path);
				films[i].setTitle(null);
				// films[i].setLastChange(lastChange);
				// films[i].setMd5(getHash(path, files[i]));
			}
		}

		return films;
	}

	/**
	 * @param path
	 * @param fileName
	 * @return
	 */
	public boolean normalizeFilmName(String path, String fileName) {

		File film = new File(path + fileName);

		if (film.exists()) {
			String fileNameNormalize = fileName.toLowerCase();

			// TODO: Review this
			// fileNameNormalize =
			/*
			 * fileNameNormalize = fileNameNormalize .replaceAll(
			 * "amelina|divx|dvdrip|spanish|ac3|www|lokotorrents|com|xvid|2009|mp3|5.1|2010|audiolatino|portorrent"
			 * , "");
			 */

			// Create the new file
			File filmNormalize = new File(path + fileNameNormalize);
			film.renameTo(filmNormalize);
			return true;

		} else {
			return false;
		}

	}

	public boolean normalizeFilmName(String path, String[] fileNames) {

		for (int i = 0; i < fileNames.length; i++) {
			normalizeFilmName(path, fileNames[i]);
		}

		return true;
	}

	@Override
	public long getChecksum(String path, String filename) throws IOException {
		
		File file = new File(path+filename);
		
		long checksum = FileUtils.checksumCRC32(file);
		
		return checksum;
	}

}
