package src.procedureJdbc;

import java.sql.SQLException;
import java.sql.Statement;

import src.models.Impression;
import src.models.Tirage;

public class TirageDAO extends ImpressionDAO{
      public Tirage find(Long id) throws SQLException {
    	  Tirage tr = (Tirage) super.find(id);
		return tr;
      }
      
      public Tirage create(Tirage obj) throws SQLException {
    	  Impression imp = super.create(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	   
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			stmt.executeUpdate("Insert into Tirage Values("+imp.getId()+","+obj.getFormat()+","+obj.getQualite()+")");
			obj.setId(imp.getId());
			stmt.close();
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			conn.commit();
			
		
    	  return obj;
      }
      
      public Tirage update(Tirage obj) throws SQLException {
    	  super.update(new Impression(obj.getFormat(),obj.getQualite(),obj.getNbExemplaire(),obj.getCmd(),obj.getSupport()));
    	   
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			stmt.executeUpdate("UPDATE Tirage SET format = '"+obj.getFormat()+"', qualite = '"+obj.getQualite()+"'"
					+ "WHERE idImpression = '"+obj.getId()+"'");
			stmt.close();
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			conn.commit();
		  
		return obj;
      }
}
