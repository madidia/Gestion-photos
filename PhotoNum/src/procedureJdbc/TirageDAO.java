package src.procedureJdbc;

import java.sql.SQLException;
import java.sql.Statement;

import src.models.Impression;
import src.models.Tirage;

public class TirageDAO extends ImpressionDAO{
      public Tirage find(Long id) {
    	  Tirage tr = (Tirage) super.find(id);
		return tr;
      }
      
      public Tirage create(Tirage obj) {
    	  Impression imp = super.create(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	  try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Insert into Tirage Values("+imp.getId()+","+obj.getFormat()+","+obj.getQualite()+")");
			obj.setId(imp.getId());
			stmt.close();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	  return obj;
      }
      
      public Tirage update(Tirage obj) {
    	  super.update(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	  try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE Tirage SET format = '"+obj.getFormat()+"', qualite = '"+obj.getQualite()+"'"
					+ "WHERE idImpression = '"+obj.getId()+"'");
			stmt.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}	  
		return obj;
      }
}
