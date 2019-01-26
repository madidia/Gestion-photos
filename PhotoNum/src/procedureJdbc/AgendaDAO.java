package procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Impression;
import models.Agenda;

public class AgendaDAO extends ImpressionDAO{
    public Agenda find(int x) {
      Agenda ag = null;
  	  Statement stmt;
  	  try {
  	  stmt = super.conn.createStatement();
  	  String query = "Select * from Agenda where idImpression = '"+x+"'";
  	  String query2 = "Select * from Impression where idImpression = '"+x+"'";
  	  ResultSet rs = stmt.executeQuery(query);
  	  ResultSet rs2 = stmt.executeQuery(query2);
	  rs = stmt.executeQuery(query);
  	  if(!rs.next())
  	  	{
			ag = new Agenda(x ,rs.getString("format"),rs.getString("qualite"),0,rs.getString("typeAgenda"),rs.getString("model"));
  		} 
  	  if(!rs2.next())
  	    {
  		    ag.setNbExemplaire(rs2.getInt("nbExemplaire"));
  	    }
  	  }
  	  catch (SQLException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
  	  return ag;
    }
    
    /*public Agenda create(Agenda obj) {
  	  super.create(new Impression(obj.get,obj.getFormat(),obj.getQualite(),0));
  	  try {
			Statement stmt = super.conn.createStatement();
			String query = "Insert into Agenda Values("+0+","+obj.getFormat()+","+obj.getQualite()+","+obj.getModel()+")";
			stmt.executeQuery(query);
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }*/
    
    public Agenda update(Agenda obj) {
  	  super.update(new Impression(0,obj.getFormat(),obj.getQualite(),0));
  	  try {
		Statement stmt = super.conn.createStatement();
		String query = "Update Agenda SET format ='"+obj.getFormat()+"',qualite='"+obj.getQualite()+"',typeAngeda ='"+obj.getModel()+"'";
		stmt.executeQuery(query);
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return obj;
    }
}
