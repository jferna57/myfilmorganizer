package net.juancarlosfernandez.apps.myFilmsOrganizer.utils;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilmSearcherTest {

	// Films tmp directory
	private String FILMS_TMP = "./target/tmp/";

	// Number off tmp films
	private int NUM_AVI_FILMS_TMP = 15;

	// Number off tmp films
	private int NUM_MPEG_FILMS_TMP = 15;

	// Number off not films files (or dummy films)
	private int NUM_NOTFILES_TMP = 10;

	// Number off directories
	private int NUM_DIR_TMP = 10;

	@Before
	public void setUp() throws Exception {

		// Create tmp films directory
		File baseDir = new File(FILMS_TMP);
		assertTrue(baseDir.mkdir());

		// Create AVI films samples files
		for (int i = 0; i < NUM_AVI_FILMS_TMP; i++) {
			File filmsTmpFiles = new File(FILMS_TMP + i
					+ "Peli_(DvdRip)_2010.avi");
			assertTrue(filmsTmpFiles.createNewFile());
		}

		// Create MPEG films samples files
		for (int i = 0; i < NUM_MPEG_FILMS_TMP; i++) {
			File filmsTmpFiles = new File(FILMS_TMP + i
					+ "Peli_(DvdRip)_2010.mpeg");
			assertTrue(filmsTmpFiles.createNewFile());
		}

		// Create not films samples files
		for (int i = 0; i < NUM_NOTFILES_TMP; i++) {
			File filmsTmpFiles = new File(FILMS_TMP + i + ".srt");
			assertTrue(filmsTmpFiles.createNewFile());
		}

		// Create subDir
		for (int i = 0; i < NUM_DIR_TMP; i++) {
			File dirTmp = new File(FILMS_TMP + i);
			assertTrue(dirTmp.mkdir());
		}
	}

	@After
	public void tearDown() throws Exception {
		File baseDir = new File(FILMS_TMP);
		// Delete AVI files
		for (int i = 0; i < NUM_AVI_FILMS_TMP; i++) {
			File filmsTmpDir = new File(FILMS_TMP + i
					+ "Peli_(DvdRip)_2010.avi");
			assertTrue(filmsTmpDir.delete());
		}

		// Delete MPEG films samples files
		for (int i = 0; i < NUM_MPEG_FILMS_TMP; i++) {
			File filmsTmpFiles = new File(FILMS_TMP + i
					+ "Peli_(DvdRip)_2010.mpeg");
			assertTrue(filmsTmpFiles.delete());
		}

		// Delete not films samples files
		for (int i = 0; i < NUM_NOTFILES_TMP; i++) {
			File filmsTmpFiles = new File(FILMS_TMP + i + ".srt");
			assertTrue(filmsTmpFiles.delete());
		}

		// Create subDir
		for (int i = 0; i < NUM_DIR_TMP; i++) {
			File dirTmp = new File(FILMS_TMP + i);
			assertTrue(dirTmp.delete());
		}

		// Delete tmp Directory
		assertTrue(baseDir.delete());
	}

	@Test
	public void testGetFilms() {
		FilmSearcher filmSearch = new FilmSearcher();
		String[] films = filmSearch.getFilms(FILMS_TMP);

		assertTrue(films.length == NUM_AVI_FILMS_TMP + NUM_MPEG_FILMS_TMP);

		for (int i = 0; i < films.length; i++)
			System.out.println(films[i]);

	}

	@Test
	public void testNormalizeFilmName() {
		FilmSearcher filmSearch = new FilmSearcher();
		String[] films = filmSearch.getFilms(FILMS_TMP);

		for (int i = 0; i < films.length; i++) {
			filmSearch.normalizeFilmName(FILMS_TMP, films[i]);
		}

		filmSearch.getFilms(FILMS_TMP);
		for (int i = 0; i < films.length; i++)
			System.out.println(films[i]);

	}

}
