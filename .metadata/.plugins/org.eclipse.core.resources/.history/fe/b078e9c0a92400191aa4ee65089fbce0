package procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Album;
import models.Impression;

public class AlbumDAO extends ImpressionDAO{
    public Album find(int x) {
        Album ab =  null;
        Impression imp = super.find(x);
        Statement stmt;
        try {
        	stmt = super.conn.createStatement();
        	String titre="",couv="";
        	String query = "Select * from Album where idImpression = '"+x+"'";
      	    ResultSet rs = stmt.executeQuery(query);
      	    if(rs.next()) {
      	    	couv=rs.getString(4);
      	    	titre=rs.getString(5);
      	    }
      	  ab = new Album(imp,titre,couv);
  		  ab.setId(imp.getId());
  		  stmt.close();
  		  conn.commit();
  		  conn.close();
        }
        catch(SQLException e1) {
      	  e1.printStackTrace();
        }
  	  	return ab;
  	}
      
      public Album create(Album obj) {
    	  Impression imp = super.create(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),
    			  obj.getCmd(),obj.getSupport()));
    	  try {
  			Statement stmt = super.conn.createStatement();
  			stmt.executeUpdate("Insert into Album Values("+imp.getId()+","+obj.getFormat()+","+obj.getQualite()
  				+","+obj.getCouverture()+","+obj.getTitre()+")");
  			obj.setId(imp.getId());
  			stmt.close();
  			conn.commit();
  			conn.close();
  		  }catch (SQLException e) {
  			e.printStackTrace();
  		  }
    	  return obj;
      }
      
      public Album update(Album obj) {
    	  super.update(new Impression(obj.getFormat(),obj.getQualite(),
    			  obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	  try {
    		  Statement stmt = super.conn.createStatement();
    		  stmt.executeUpdate("Update Album SET format ='"+obj.getFormat()+"',qualite='"+
    				  obj.getQualite()+"',model ='"+obj.getCouverture()+"',couverture ='"+
    				  obj.getTitre()+"' WHERE idImpression ='"+obj.getId()+"'");
    		  stmt.close();
    		  conn.commit();
    		  conn.close();
    	  }catch (SQLException e) {
    		  e.printStackTrace();
    	  }
    	  return obj;
      }
}
