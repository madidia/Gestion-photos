package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Calendrier;
import models.Impression;

public class CalendrierDAO extends ImpressionDAO{
    public Calendrier find(int x) {
        Calendrier cd =  null;
        Impression imp = super.find(x);
        Statement stmt;
        try {
      	  stmt = conn.createStatement();
        	  String query = "Select * from Calendrier where idImpression = '"+x+"'";
      	  ResultSet rs = stmt.executeQuery(query);
      	  if(rs.next())
      	  {
      		  cd = new Calendrier(imp,rs.getString("model"));
      	  }
        }
        catch(SQLException e1) {
      	  e1.printStackTrace();
        }
  	  return cd;  
      }
      
      public Calendrier create(Calendrier obj) {
    	  Impression imp = super.create(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	  try {
  			Statement stmt = conn.createStatement();
  			String query = "Insert into Calendrier Values("+imp.getId()+",'"+obj.getFormat()+"','"+obj.getQualite()+"','"+obj.getModel()+"')";
  			stmt.executeQuery(query);
  			obj.setId(imp.getId());
  			return obj;
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  		return obj;
      }
      
      public Calendrier update(Calendrier obj) {
    	  super.create(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	  try {
  		Statement stmt = conn.createStatement();
  		String query = "Update Calendrier SET format ='"+obj.getFormat()+"',qualite='"+obj.getQualite()+"'"
  				+ ",model ='"+obj.getModel()+"' WHERE idImpression ='"+obj.getId()+"'";
  		stmt.executeQuery(query);
  	} catch (SQLException e) {
  		e.printStackTrace();
  	}
  		return obj;
    }
}
