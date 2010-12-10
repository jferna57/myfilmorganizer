package net.juancarlosfernandez.myfilms.utils.filmaffinity;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class FilmAffinityPosterPluginTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIdFromMovieInfoStringStringInt() {
		FilmAffinityPosterPlugin posterPlugin = new FilmAffinityPosterPlugin();
		
		String poster = posterPlugin.getIdFromMovieInfo("El padrino", "1972");
		
		IImage image = posterPlugin.getPosterUrl(poster);
		
		assertTrue(poster.equalsIgnoreCase("809297.html"));
		
		assertTrue(image.getUrl().equalsIgnoreCase("http://pics.filmaffinity.com/El_Padrino-485345341-large.jpg"));
	}

	@Ignore
	public void testGetPosterUrlString() {
		fail("Not yet implemented");
	}

}
