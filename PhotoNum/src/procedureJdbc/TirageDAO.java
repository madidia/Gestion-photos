package procedureJdbc;

import java.sql.SQLException;
import java.sql.Statement;

import models.Impression;
import models.Tirage;

public class TirageDAO extends ImpressionDAO{
      public Tirage find(Long x) {
    	  super.find(x);
		return new Tirage(super.find(x).getFormat(), super.find(x).getQualite());
      }
      
      public Tirage create(Tirage obj) {
    	  super.create(new Impression(0,obj.getFormat(),obj.getQualite(),0));
    	  try {
			Statement stmt = super.conn.createStatement();
			String query = "Insert into Tirage Values("+0+","+obj.getFormat()+","+obj.getQualite()+")";
			stmt.executeQuery(query);
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
      }
      
      public Tirage update(Tirage obj) {
    	  super.update(new Impression(0,obj.getFormat(),obj.getQualite(),0));
		return obj;
      }
}
