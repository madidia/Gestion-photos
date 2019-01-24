package procedureJdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Client;

public class ClientDAO extends DAO<Client>{
    Connection conn;
	
	@Override
	public Client find(String id) {
	   	Statement stmt;
		try {
			stmt = conn.createStatement();
	    	String query1 = "Select * from Utilisateur where mailU = '"+id+"' ";
	    	ResultSet rs = stmt.executeQuery(query1);
	    	if(rs.next())
	    	  return new Client(rs.getString("mailC"), rs.getString("nomC") , rs.getString("prenomC") , rs.getString("mdpasseC"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client create(Client obj) {
	   try {
		   Statement stmt = conn.createStatement();
		   String query1 = "Select mailU from Utilisateur where mailU = '"+obj.getMail()+"' ";
		   ResultSet rs = stmt.executeQuery(query1);
		   if(!rs.next()) {
	 		 String query2 = "INSERT INTO Utilisateur Values ('"+obj.getMail()+"')";
	 		 String query3 = "INSERT INTO ClientP Values ('"+obj.getMail()+"','"+obj.getNom()+"','"+obj.getPrenom()+"','"+obj.getPassword()+"')";
	 		 stmt.executeQuery(query2);
	 		 stmt.executeQuery(query3);
	 		 return obj;
		   } else {
	 		   System.out.println("mail déja utilisé");
		   }
	   	} catch (SQLException e) {
		   e.printStackTrace();
	   		}
	   return null; 
    }

	@Override
	public Client update(Client obj) {
		try {
			Statement stmt = conn.createStatement();
			String query = "Update ClientP SET nomC ='"+obj.getNom()+"' and '"+obj.getPrenom()+"' and '"+obj.getPassword()+"'";
			stmt.executeQuery(query);
			
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void delete(Client obj) {
		try {
			Statement stmt = conn.createStatement();
			String query = "DELETE ON ClientP where mailC = '"+obj.getMail()+"'";
			stmt.executeQuery(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
