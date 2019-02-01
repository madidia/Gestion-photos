package src.procedureJdbc;

import java.sql.SQLException;
import java.sql.Statement;

import src.models.Code;
import src.models.CodeMarketing;

public class CodeMarketingDAO extends CodeDAO{
	
    public CodeMarketing find(String x) throws SQLException {
  	  CodeMarketing code =  (CodeMarketing) super.find(x);
	  return code;
    }
    /**
     * 
     * @param obj
     * @return
     * @throws SQLException
     */
    public CodeMarketing create(CodeMarketing obj) throws SQLException {
    	super.create(new Code(obj.getIdCode(),obj.getValeur()));
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Insert into CodeMarketing Values("+obj.getIdCode()+","+obj.getValeur()+")");
			stmt.close();
			conn.commit();	
  	  	return obj;
    }
    
    /**
     * 
     * @param obj
     * @return
     * @throws SQLException
     */
    public CodeMarketing update(CodeMarketing obj) throws SQLException {
  	  super.update(new Code(obj.getIdCode(),obj.getValeur()));
  	  
			Statement stmt = conn.createStatement();
			stmt.executeQuery("UPDATE CodeMarketing SET valeur = '"+obj.getValeur()+
					"' where code = '"+obj.getIdCode()+"'");
			stmt.close();
			conn.commit();		  
		return obj;
    }
}
