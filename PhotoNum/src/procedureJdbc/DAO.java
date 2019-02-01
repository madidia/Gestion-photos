package src.procedureJdbc;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAO<T> {

	public static Connection conn;
	/**
	 * Permet de r�cup�rer un objet via son ID
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public abstract T find(String id) throws SQLException;

	/**
	 * Permet de r�cup�rer un objet via son ID
	 * @param id
	 * @return
	 */
	public abstract T find(long id)throws SQLException;


	/**
	 * Permet de cr�er une entr�e dans la base de donn�es
	 * par rapport � un objet
	 * @param obj
	 * @throws SQLException 
	 */
	public abstract T create(T obj) throws SQLException;

	/**
	 * Permet de mettre � jour les donn�es d'une entr�e dans la base 
	 * @param obj
	 * @throws SQLException 
	 */
	public abstract T update(T obj) throws SQLException;

	/**
	 * Permet la suppression d'une entr�e de la base
	 * @param obj
	 */
	public abstract void delete(T obj)throws SQLException;


}
