package net.juancarlosfernandez.myfilms.services.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.Reader;
import java.sql.Connection;

import net.juancarlosfernandez.myfilms.domain.Film;
import net.juancarlosfernandez.myfilms.services.IFilmService;
import net.juancarlosfernandez.myfilms.utils.DBUtils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FilmServiceTest {

	private final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private final String DB_URL = "jdbc:derby:./target/DerbyDB/samplePelisDB;create=true";

	ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"spring-context.xml");

	@Before
	public void setUp() throws Exception {
		Connection conn = DBUtils.getConnection(DB_DRIVER, DB_URL);
		try {
			ScriptRunner runner = new ScriptRunner(conn);
			runner.setErrorLogWriter(null);
			runner.setLogWriter(null);
			Reader reader = Resources.getResourceAsReader("sample-data.sql");
			runner.runScript(reader);
		} finally {
			if (conn != null)
				conn.close();
		}

	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	public void testAddFilm() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testDeleteFilm() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchFilm() {
		IFilmService service = (IFilmService) ctx.getBean("filmService");

		Film film = new Film();
		film.setIdFilm(1);
		film = service.searchFilm(film);

		if (film != null) {
			assertTrue(film.getIdFilm() == 1);
			assertTrue(film.getFilename().equalsIgnoreCase("filename-1"));
			assertTrue(film.getLocation().equalsIgnoreCase("location-1"));
			assertTrue(film.getTitle().equalsIgnoreCase("title-1"));

		} else {
			fail("Film not found - IdFilm " + 1);
		}
	}

	@Ignore
	public void testModifyFilm() {
		fail("Not yet implemented");
	}

}
