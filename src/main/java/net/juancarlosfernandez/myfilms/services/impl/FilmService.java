package net.juancarlosfernandez.myfilms.services.impl;

import net.juancarlosfernandez.myfilms.domain.Film;
import net.juancarlosfernandez.myfilms.mapper.FilmMapper;
import net.juancarlosfernandez.myfilms.services.IFilmService;

public class FilmService implements IFilmService {

	private FilmMapper filmMapper;

	public FilmMapper getFilmMapper() {
		return filmMapper;
	}

	public void setFilmMapper(FilmMapper filmMapper) {
		this.filmMapper = filmMapper;
	}

	@Override
	public void addFilm(Film film) {
		filmMapper.insert(film);
	}

	@Override
	public void deleteFilm(Film film) {
		filmMapper.deleteByPrimaryKey(film.getIdFilm());
	}

	@Override
	public Film searchFilm(Film film) {
		return filmMapper.selectByPrimaryKey(film.getIdFilm());
	}

	@Override
	public void modifyFilm(Film filmModified) {
		filmMapper.updateByPrimaryKey(filmModified);

	}

}
