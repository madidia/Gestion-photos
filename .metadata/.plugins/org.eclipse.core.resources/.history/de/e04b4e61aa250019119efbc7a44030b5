package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.models.Cadre;
import src.models.Impression;

public class CadreDAO extends ImpressionDAO{
    public Cadre find(int x) throws SQLException {
        Cadre cd =  null;
        Impression imp = super.find(x);
        Statement stmt;
          
        	stmt = conn.createStatement();
        	String taille="",model="";
        	String query = "Select * from Cadre where idImpression = '"+x+"'";
        	ResultSet rs = stmt.executeQuery(query);
      	  if(rs.next()){
      		  taille=rs.getString(4);
      		  model=rs.getString(5);
      		cd = new Cadre(imp,taille,model);
      	  }else {
      		  System.out.println("Ce cadre n'hexiste pas");
      	  }
      	  
      	  rs.close();
      	  stmt.close();
        
        
        return cd;  
  	  }

      
      public Cadre create(Cadre obj) throws SQLException {
    	  Impression imp = super.create(new Impression(obj.getFormat(),obj.getQualite(),
    			  obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	    
  			Statement stmt = conn.createStatement();
  			conn.setAutoCommit(false);
  			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
  			stmt.executeUpdate("Insert into Cadre Values("+imp.getId()+",'"+obj.getFormat()
  				+"','"+obj.getQualite()+"','"+obj.getTaille()+"','"+obj.getModel()+"')");
  			obj.setId(imp.getId());
  			stmt.close();
  			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
  			conn.commit();
  		
  		return obj;
      }
      
      public Cadre update(Cadre obj) throws SQLException {
    	  super.create(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	    
    		  Statement stmt = conn.createStatement();
    		  conn.setAutoCommit(false);
    		  conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
    		  stmt.executeUpdate("Update Cadre SET format ='"+obj.getFormat()+"',qualite='"+obj.getQualite()
    		  	+"',taille ='"+obj.getTaille()+"',model ='"+obj.getModel()+"' WHERE idImpression ='"+obj.getId()+"'");
    		  stmt.close();
    		  conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
    		  conn.commit();
    	  
    	  return obj;
      }
}
