package net.juancarlosfernandez.apps.myFilmsOrganizer.test.utils;

import static org.junit.Assert.assertTrue;

import java.io.File;

import net.juancarlosfernandez.apps.myFilmsOrganizer.service.FileUtils;
import net.juancarlosfernandez.apps.myFilmsOrganizer.service.FilmSearcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FilmSearcherTest {

	// Films tmp directory
	private String FILMS_TMP = "./target/tmp/";

	// Number off tmp films
	private int NUM_AVI_FILMS_TMP = 0;

	// Number off tmp films
	private int NUM_MPEG_FILMS_TMP = 0;

	// Number off not films files (or dummy films)
	private int NUM_NOTFILES_TMP = 10;

	// Number off directories
	private int NUM_DIR_TMP = 10;
	
	// Sample real films names
	private String [] SAMPLE_FILE_NAMES = { 
			"9 [2009]DvdRip-XviD.AudioLatino-JcGoku21.avi",
			"25.Kilates.Spanish.XviD.MP3.DVDRip.By.FreAk.TEAm.avi",
			"37 Horas desesperadas.(DVDRip.Spanish).Www.LokoTorrents.Com.avi",
			"2010.Odisea 2.(DVDRip.Divx.Spanish).www.lokotorrents.com.avi",
			"After.2009.Spanish.DVDRip.Xvid [www.PorTorrent.com].avi",
			"Airbender.El ultimo guerrero[DVDrip][AC3 Spanish][www.lokotorrents.com].avi",
			"Algo Pasa en Hollywood[DVDrip][AC3 Spanish][www.lokotorrents.com].avi",
			"Alicia.En.El.Pais.De.Las.Maravillas.(Spanish).2010.DVDRip.Xvid.Ac3.5.1.Amelina.avi",
			"Al Limite 2009 (Mel Gibson) DVDrip Spanish XVID By Jmom.avi",
			"Amazing.Grace.Spanish.XviD.MP3.DVDRip.By.FreAk.TEAm.avi",
			"Arrastrame.Al.Infierno.Spanish.XviD.MP3.DVDRip.By.FreAk.TEAm.avi",
			"Arsene.Lupin.Spanish.DVDrip.(spanish).www.lokotorrents.com.avi",
			"Batman.Under.The.Red.Hood.(Spanish).2010.DVDRip.Xvid.Ac3.5.1.Amelina.avi",
			"Battlestar Galactica The Plan [DVDRIP][Spanish AC3 5.1][Spanish][2010].avi",
			"Cashback (DVDRip) (EliteTorrent.net).avi",
			"Como Entrenar A Tu Dragon [DVDrip][spanish][www.lokotorrents.com][2010].avi"};

	@Before
	public void setUp() throws Exception {

		// Create tmp films directory
		File baseDir = new File(FILMS_TMP);
		
		if ( ! baseDir.exists()) {
		
			assertTrue(baseDir.mkdir());
			
			assertTrue(FileUtils.createFiles(FILMS_TMP,SAMPLE_FILE_NAMES));
			
			// Create AVI films samples files
			for (int i = 0; i < NUM_AVI_FILMS_TMP; i++) {
				File filmsTmpFiles = new File(FILMS_TMP + i
						+ "Peli_(DvdRip)_Spanish_2010.avi");
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
	}

	@After
	public void tearDown() throws Exception {
		File baseDir = new File(FILMS_TMP);
		
		assertTrue(FileUtils.deleteDirectory(baseDir));

	}

	@Test
	public void testGetFilms() {
		FilmSearcher filmSearch = new FilmSearcher();
		String[] films = filmSearch.getFilms(FILMS_TMP);

		assertTrue(films.length == NUM_AVI_FILMS_TMP + NUM_MPEG_FILMS_TMP + SAMPLE_FILE_NAMES.length);

		// for (int i = 0; i < films.length; i++)
		// System.out.println(films[i]);

	}

	@Test
	public void testNormalizeFilmName() {
		FilmSearcher filmSearch = new FilmSearcher();
		String[] films = filmSearch.getFilms(FILMS_TMP);

		for (int i = 0; i < films.length; i++) {
			filmSearch.normalizeFilmName(FILMS_TMP, films);
		}

		films = filmSearch.getFilms(FILMS_TMP);
		for (int i = 0; i < films.length; i++)
			System.out.println(films[i]);

	}

}
