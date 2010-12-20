package net.juancarlosfernandez.myfilms;

import java.io.IOException;

import net.juancarlosfernandez.myfilms.services.IFilmService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"spring-context.xml");

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// If path exist then
		IFilmService service = (IFilmService) ctx.getBean("filmService");
		
		try {
			service.addFilmFromLocations(args);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
