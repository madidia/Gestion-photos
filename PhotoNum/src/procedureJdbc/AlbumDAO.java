package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.models.Album;
import src.models.Impression;

public class AlbumDAO extends ImpressionDAO{
    public Album find(int x) throws SQLException {
        Album ab =  null;
        Impression imp = super.find(x);
        Statement stmt;
       
        	stmt = conn.createStatement();
        	String titre="";
        	int couv=0;
        	String query = "Select * from Album where idImpression = '"+x+"'";
      	    ResultSet rs = stmt.executeQuery(query);
      	    if(rs.next()) {
      	    	couv=rs.getInt(4);
      	    	titre=rs.getString(5);
      	    	ab = new Album(imp,titre,couv);
      	    	ab.setId(imp.getId());
      	    }
      	  
  		  rs.close();
  		  stmt.close();
        
        
  	  	return ab;
  	}
      
      public Album create(Album obj)throws SQLException  {
    	  Impression imp = super.create(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),
    			  obj.getCmd(),obj.getSupport()));
    	    
  			Statement stmt = conn.createStatement();
  			conn.setAutoCommit(false);
  		    conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
  			stmt.executeUpdate("Insert into Album Values("+imp.getId()+",'"+obj.getFormat()+"','"+obj.getQualite()+"',"+obj.getCouverture()+",'"+obj.getTitre()+"')");
  			obj.setId(imp.getId());
  			stmt.close();
  			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
  			conn.commit();
    	  return obj;
      }
      
      public Album update(Album obj) throws SQLException {
    	  super.update(new Impression(obj.getFormat(),obj.getQualite(),
    			  obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	    
    		  Statement stmt = conn.createStatement();
    		  conn.setAutoCommit(false);
    		  conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
    		  stmt.executeUpdate("Update Album SET format ='"+obj.getFormat()+"',qualite='"+
    				  obj.getQualite()+"',model ='"+obj.getCouverture()+"',couverture ='"+
    				  obj.getTitre()+"' WHERE idImpression ='"+obj.getId()+"'");
    		  stmt.close();
    		  conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
    		  conn.commit();
    	  
    	  return obj;
      }
}
