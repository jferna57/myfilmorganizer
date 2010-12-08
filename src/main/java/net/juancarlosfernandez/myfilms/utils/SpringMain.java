package net.juancarlosfernandez.myfilms.utils;

import net.juancarlosfernandez.myfilms.domain.Film;
import net.juancarlosfernandez.myfilms.services.IFilmService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] _args) throws Exception {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
		IFilmService service = (IFilmService) ctx.getBean("filmService");

		Film film = new Film();
		film.setIdFilm(1);
		film = service.searchFilm(film);
		
		System.out.println("Film - " + film.getTitle());
	}    
}