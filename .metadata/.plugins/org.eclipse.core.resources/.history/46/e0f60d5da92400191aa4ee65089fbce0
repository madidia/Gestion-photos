package procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Impression;
import models.Agenda;

public class AgendaDAO extends ImpressionDAO{
    public Agenda find(int x) {
      Agenda ag =  null;
      Impression imp = super.find(x);
      Statement stmt;
      try {
    	  
    	  stmt = super.conn.createStatement();
    	  String typeAgenda="",modele="";
      	  String query = "Select * from Agenda where idImpression = '"+x+"'";
    	  ResultSet rs = stmt.executeQuery(query);
    	  if(rs.next()){
    		  typeAgenda=rs.getString(4);
    		  modele=rs.getString(5);
    	  }
    	  ag = new Agenda(imp,typeAgenda,modele);
    	  stmt.close();
    	  conn.commit();
    	  conn.close();  
      }
      catch(SQLException e1) {
    	  e1.printStackTrace();
      }
	  return ag;  
    }
    
    public Agenda create(Agenda obj) {
  	  Impression imp = super.create(new Impression(obj.getFormat(),obj.getQualite(),
  			  obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
  	  try {
			Statement stmt = super.conn.createStatement();
			stmt.executeUpdate("Insert into Agenda Values("+imp.getId()+","+obj.getFormat()+","+
					obj.getQualite()+","+obj.getTypeAgenda()+","+obj.getModel()+")");
			
			obj.setId(imp.getId());
			stmt.close();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
    }
    
    public Agenda update(Agenda obj) {
  	  super.update(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
  	  try {
		Statement stmt = super.conn.createStatement();
		stmt.executeUpdate("Update Agenda SET format ='"+obj.getFormat()+"',qualite='"+obj.getQualite()+
				"',typeAgenda ='"+obj.getTypeAgenda()+"'"+ ",model ='"+obj.getModel()+
				"' WHERE idImpression ='"+obj.getId()+"'");
		stmt.close();
		conn.commit();
		conn.close();
  	  } catch (SQLException e) {
		e.printStackTrace();
  	  }
		return obj;
    }
}
