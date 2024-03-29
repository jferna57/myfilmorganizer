package net.juancarlosfernandez.myfilms.mapper;

import java.util.List;
import net.juancarlosfernandez.myfilms.domain.Film;
import net.juancarlosfernandez.myfilms.domain.FilmExample;
import org.apache.ibatis.annotations.Param;

public interface FilmMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    int countByExample(FilmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    int deleteByExample(FilmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    int deleteByPrimaryKey(Long idFilm);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    int insert(Film record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    int insertSelective(Film record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    List<Film> selectByExampleWithBLOBs(FilmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    List<Film> selectByExample(FilmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    Film selectByPrimaryKey(Long idFilm);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    int updateByExampleSelective(@Param("record") Film record, @Param("example") FilmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    int updateByExampleWithBLOBs(@Param("record") Film record, @Param("example") FilmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    int updateByExample(@Param("record") Film record, @Param("example") FilmExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    int updateByPrimaryKeySelective(Film record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    int updateByPrimaryKeyWithBLOBs(Film record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table FILM
     *
     * @mbggenerated Fri Dec 10 20:19:30 CET 2010
     */
    int updateByPrimaryKey(Film record);
}