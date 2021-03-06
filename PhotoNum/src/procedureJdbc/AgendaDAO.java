package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.models.Agenda;
import src.models.Impression;

public class AgendaDAO extends ImpressionDAO {
	public Agenda find(int x)throws SQLException  {
		Agenda ag =  null;
		Impression imp = super.find(x);
		Statement stmt;

		stmt = conn.createStatement();
		String typeAgenda="",modele="";
		String query = "Select * from Agenda where idImpression = '"+x+"'";
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()){
			typeAgenda=rs.getString(4);
			modele=rs.getString(5);
		}
		ag = new Agenda(imp,typeAgenda,modele);
		stmt.close();

		return ag;  
	}

	public Agenda create(Agenda obj) throws SQLException {
		Impression imp = super.create(new Impression(obj.getFormat(),obj.getQualite(),
				obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Insert into Agenda Values("+imp.getId()+",'"+obj.getFormat()+"','"+
				obj.getQualite()+"','"+obj.getTypeAgenda()+"','"+obj.getModel()+"')");

		obj.setId(imp.getId());
		stmt.close();
		conn.commit();

		return obj;
	}

	public Agenda update(Agenda obj) throws SQLException {
		super.update(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Update Agenda SET format ='"+obj.getFormat()+"',qualite='"+obj.getQualite()+
				"',typeAgenda ='"+obj.getTypeAgenda()+"'"+ ",model ='"+obj.getModel()+
				"' WHERE idImpression ='"+obj.getId()+"'");
		stmt.close();
		conn.commit();

		return obj;
	}
}
