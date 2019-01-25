package procedureJdbc;

import java.sql.SQLException;
import java.sql.Statement;

import models.Impression;
import models.Tirage;

public class TirageDAO extends ImpressionDAO{
      public Tirage find(Long id) {
    	  Tirage tr = (Tirage) super.find(id);
		return tr;
      }
      
      public Tirage create(Tirage obj) {
    	  super.create(new Impression(obj.getId(),obj.getFormat(),obj.getQualite(),obj.getNbExemplaire()));
    	  try {
			Statement stmt = super.conn.createStatement();
			String query = "Insert into Tirage Values("+obj.getId()+","+obj.getFormat()+","+obj.getQualite()+")";
			stmt.executeQuery(query);
			stmt.close();
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
      }
      
      public Tirage update(Tirage obj) {
    	  super.update(new Impression(obj.getId(),obj.getFormat(),obj.getQualite(),obj.getNbExemplaire()));
    	  try {
			Statement stmt = super.conn.createStatement();
			String query = "UPDATE Tirage SET format = '"+obj.getFormat()+"', qualite = '"+obj.getQualite()+"'";
			stmt.executeQuery(query);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	  
		return obj;
      }
}
