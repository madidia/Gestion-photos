package src.procedureJdbc;

import java.sql.SQLException;
import java.util.ArrayList;

import src.models.Adresse;

public abstract class UtilisateurDAO<T> extends DAO<T> {
	
		/**
		 * allow to delete an object  via his ID
		 * @param id
		 * @return
		 * @throws SQLException 
		 */
	 	public abstract T find(String id) throws SQLException;
	 	
	 	/**
		 * allow to delete an object  via his ID
		 * @param id
		 * @return
		 */
	 	
	 
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
		
		/**
		 * 
		 * @param obj
		 * @return les adresses d'un utilisateur
		 * @throws SQLException
		 */
		public abstract ArrayList<Adresse> getAdresse(T obj) throws SQLException;
	
}
