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
    	  Impression imp = super.create(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	  try {
			Statement stmt = super.conn.createStatement();
			String query = "Insert into Tirage Values("+imp.getId()+","+obj.getFormat()+","+obj.getQualite()+")";
			stmt.executeQuery(query);
			obj.setId(imp.getId());
			stmt.close();
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
      }
      
      public Tirage update(Tirage obj) {
    	  super.update(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	  try {
			Statement stmt = super.conn.createStatement();
			String query = "UPDATE Tirage SET format = '"+obj.getFormat()+"', qualite = '"+obj.getQualite()+"'"
					+ "WHERE idImpression = '"+obj.getId()+"'";
			stmt.executeQuery(query);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	  
		return obj;
      }
}
