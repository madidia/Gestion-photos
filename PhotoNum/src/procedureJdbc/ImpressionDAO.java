package procedureJdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Impression;

public class ImpressionDAO extends DAO<Impression>{
    Connection conn;
	@Override
	public Impression find(String id) {
		return null;
	}

	@Override
	public Impression find(long id) {
		id = (int) id;
	   	Statement stmt;
		try {
			stmt = conn.createStatement();
	    	String query1 = "Select * from Impression where idImpression = '"+id+"' ";
	    	ResultSet rs = stmt.executeQuery(query1);
	    	if(rs.next())
	    	  return new Impression(rs.getInt(0),rs.getString(1),rs.getString(2),rs.getInt(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Impression create(Impression obj) {
		   try {
			   Statement stmt = conn.createStatement();
		 	   String query = "INSERT INTO ClientP Values ('"+obj.getId()+"','"+obj.getFormat()+"','"+obj.getQualite()+"','"+obj.getNbExemplaire()+"')";
		 	   stmt.executeQuery(query);
		 	   return obj;
		   	} catch (SQLException e) {
			   e.printStackTrace();
		   		}
		   return null; 
	}

	@Override
	public Impression update(Impression obj) {
		try {
			Statement stmt = conn.createStatement();
			String query = "Update Impression SET idImpression ='"+obj.getId()+"' ,format ='"+obj.getFormat()+"',qualite ='"+obj.getQualite()+"'"
					         + ", nbExemplaire ='"+obj.getNbExemplaire()+"'";
			stmt.executeQuery(query);
			
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Impression obj) {
		try {
			Statement stmt = conn.createStatement();
			String query = "DELETE ON Impression where idImpression = '"+obj.getId()+"'";
			stmt.executeQuery(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
}
