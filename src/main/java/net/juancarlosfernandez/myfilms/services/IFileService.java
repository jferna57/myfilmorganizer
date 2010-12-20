package net.juancarlosfernandez.myfilms.services;

import java.io.IOException;

import net.juancarlosfernandez.myfilms.domain.Film;


public interface IFileService {

	public abstract Film[] getFilms(String path) throws IOException;
	
	public abstract long getChecksum(String path, String filename) throws IOException;
}