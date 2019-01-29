package procedureJdbc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Administrateur;

public class AdministrateurDAO extends UtilisateurDAO<Administrateur> {

	@Override
	public Administrateur find(String mail) {
		Statement stmt;
		Administrateur admin = null;
		
		try {
			stmt = conn.createStatement();
			String query = "Select * from ClientP where mailC = '"+mail+"' ";
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()){
				admin = new Administrateur(rs.getString("mailA"), rs.getString("nomA") , rs.getString("prenomA") , rs.getString("mdpasseA"));
				rs.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return admin;
	}

	@Override
	public Administrateur create(Administrateur obj) {
			
		try {
			Statement stmt  = conn.createStatement();
			String query = "Select * from Administrateur where mailA = '"+obj.getMail() +"'";
			ResultSet rs = stmt.executeQuery(query);
			if(!rs.next()) {
		 		 String query2 = "INSERT INTO Utilisateur Values ('"+obj.getMail()+"')";
		 		 String query3 = "INSERT INTO ClientP Values ('"+obj.getMail()+"','"+obj.getNom()+"','"+obj.getPrenom()+"','"+obj.getPassword()+"')";
		 		 stmt.executeQuery(query2);
		 		 stmt.executeQuery(query3);
		 		 rs.close();
		 		 stmt.close();
		 		 return obj;
			   } else {
		 		   System.out.println("cette adresse mail est deja utilis�e");
			   }
		   	} catch (SQLException e) {
			   e.printStackTrace();
		   		}
		 
		return null;
	}

	@Override
	public Administrateur update(Administrateur obj) {
		try {
			Statement stmt = conn.createStatement();
			String query = " Update Administrateur SET nomA ='"+obj.getNom()+"' ,prenomA ='"+obj.getPrenom()+"',mdpasseA ='"+obj.getPassword()+"'"
					+ "WHERE mailA ='"+obj.getMail()+"'";
			stmt.executeQuery(query);
			stmt.close();
			return obj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void delete(Administrateur obj) {
		try {
			Statement stmt = conn.createStatement();
			String query = "DELETE ON Administrateur where mailA = '"+obj.getMail()+"'";
			stmt.executeQuery(query);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
