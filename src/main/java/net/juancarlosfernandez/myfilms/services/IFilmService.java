package net.juancarlosfernandez.myfilms.services;

import net.juancarlosfernandez.myfilms.domain.Film;

public interface IFilmService {
	
	public abstract void addFilm(Film film);
	
	public abstract void deleteFilm(Film film);
	
	public abstract Film searchFilm(Film film);
	
	public void modifyFilm(Film filmModified);

}
