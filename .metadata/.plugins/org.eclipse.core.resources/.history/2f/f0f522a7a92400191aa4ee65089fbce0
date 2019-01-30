package procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Cadre;
import models.Impression;

public class CadreDAO extends ImpressionDAO{
    public Cadre find(int x) {
        Cadre cd =  null;
        Impression imp = super.find(x);
        Statement stmt;
        try {
        	stmt = super.conn.createStatement();
        	String taille="",model="";
        	String query = "Select * from Cadre where idImpression = '"+x+"'";
        	ResultSet rs = stmt.executeQuery(query);
      	  if(rs.next()){
      		  taille=rs.getString(4);
      		  model=rs.getString(5);
      	  }
      	  cd = new Cadre(imp,taille,model);
      	  stmt.close();
      	  conn.commit();
      	  conn.close();
        }
        catch(SQLException e1) {
      	  e1.printStackTrace();
        }
        return cd;  
  	  }
      
      public Cadre create(Cadre obj) {
    	  Impression imp = super.create(new Impression(obj.getFormat(),obj.getQualite(),
    			  obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	  try {
  			Statement stmt = super.conn.createStatement();
  			stmt.executeUpdate("Insert into Cadre Values("+imp.getId()+","+obj.getFormat()
  				+","+obj.getQualite()+","+obj.getTaille()+","+obj.getModel()+")");
  			obj.setId(imp.getId());
  			stmt.close();
  			conn.commit();
  			conn.close();
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  		return obj;
      }
      
      public Cadre update(Cadre obj) {
    	  super.create(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	  try {
    		  Statement stmt = super.conn.createStatement();
    		  stmt.executeUpdate("Update Cadre SET format ='"+obj.getFormat()+"',qualite='"+obj.getQualite()
    		  	+"',taille ='"+obj.getTaille()+"',model ='"+obj.getModel()+"' WHERE idImpression ='"+obj.getId()+"'");
    		  stmt.close();
    		 conn.commit();
    		 conn.close();
    	  } catch (SQLException e) {
    		  e.printStackTrace();
    	  }
    	  return obj;
      }
}
