package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.models.Calendrier;
import src.models.Impression;

public class CalendrierDAO extends ImpressionDAO{
	public Calendrier find(int x) throws SQLException {
		Calendrier cd =  null;
		Impression imp = super.find(x);
		Statement stmt;

		stmt = conn.createStatement();
		String query = "Select * from Calendrier where idImpression = '"+x+"'";
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()){
			cd = new Calendrier(imp,rs.getString("model"));
		}else {
			System.out.println("Ce calendrier n'hexiste pas");
		}
		rs.close();
		stmt.close();

		return cd;  
	}

	public Calendrier create(Calendrier obj) throws SQLException {
		Impression imp = super.create(new Impression(obj.getFormat(),obj.getQualite(),
				obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Insert into Calendrier Values("+imp.getId()+",'"+
				obj.getFormat()+"','"+obj.getQualite()+"','"+obj.getModel()+"')");
		obj.setId(imp.getId());
		stmt.close();
		conn.commit();
		return obj;

	}

	public Calendrier update(Calendrier obj)throws SQLException {
		super.create(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),
				obj.getCmd(),obj.getSupport()));

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Update Calendrier SET format ='"+obj.getFormat()+
				"',qualite='"+obj.getQualite()+"'"
				+ ",model ='"+obj.getModel()+"' WHERE idImpression ='"+obj.getId()+"'");
		stmt.close();
		conn.commit();

		return obj;
	}
}
