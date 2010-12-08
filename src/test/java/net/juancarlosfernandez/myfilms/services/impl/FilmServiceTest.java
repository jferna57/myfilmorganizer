package net.juancarlosfernandez.myfilms.services.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import net.juancarlosfernandez.myfilms.domain.Film;
import net.juancarlosfernandez.myfilms.services.IFilmService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FilmServiceTest {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");

	@Before
	public void setUp() throws Exception {
		
		Film film = new Film();
		film.setIdFilm(100);
		film.setFilename("filename-100");
		film.setTitle("title-100");
		film.setLocation("location-100");
		film.setMd5("md5-100");
		
		IFilmService service = (IFilmService) ctx.getBean("filmService");
		service.addFilm(film);
	}

	@After
	public void tearDown() throws Exception {
		
		Film film = new Film();
		film.setIdFilm(100);
		
		IFilmService service = (IFilmService) ctx.getBean("filmService");
		service.deleteFilm(film);
		
	}

	@Test
	public void testAddFilm() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteFilm() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchFilm() {
		IFilmService service = (IFilmService) ctx.getBean("filmService");

		Film film = new Film();
		film.setIdFilm(100);
		film = service.searchFilm(film);
		
		if (film != null) {
			assertTrue(film.getIdFilm()==100);
			assertTrue(film.getFilename().equalsIgnoreCase("filename-100"));
			assertTrue(film.getLocation().equalsIgnoreCase("location-100"));
			assertTrue(film.getTitle().equalsIgnoreCase("title-100"));
			
		} else {
			fail("Film not found - IdFilm " + 100);
		}
	}

	@Test
	public void testModifyFilm() {
		fail("Not yet implemented");
	}

}
