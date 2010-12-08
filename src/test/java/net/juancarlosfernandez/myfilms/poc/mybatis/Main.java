package net.juancarlosfernandez.myfilms.poc.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import net.juancarlosfernandez.myfilms.domain.Film;
import net.juancarlosfernandez.myfilms.mapper.FilmMapper;
import net.juancarlosfernandez.myfilms.utils.DBUtils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Main {

	public static void main(String args[]) {

		String resource = "ibatis-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			SqlSession sqlSession = null;
			
			try {
				
				sqlSession = sqlMapper.openSession(DBUtils.getConnection());
				FilmMapper filmMapper = sqlSession.getMapper(FilmMapper.class);
				
				Film film = filmMapper.selectByPrimaryKey(1);
				
				System.out.println("Id_Film " + film.getIdFilm());
				
				sqlSession.close();
			} catch (SQLException e) {
				System.out.println("Problema al crear la conexion");
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error");
		}

		System.out.println("ok");

	}

}
