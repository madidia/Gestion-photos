package src.procedureJdbc;

import java.sql.SQLException;
import java.sql.Statement;

import src.models.Code;
import src.models.CodeMarketing;

public class CodeMarketingDAO extends CodeDAO{
	
    public CodeMarketing find(String x) {
  	  CodeMarketing code =  (CodeMarketing) super.find(x);
	  return code;
    }
      
    public CodeMarketing create(CodeMarketing obj) {
    	super.create(new Code(obj.getIdCode(),obj.getValeur()));
    	try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Insert into CodeMarketing Values("+obj.getIdCode()+","+obj.getValeur()+")");
			stmt.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
  	  	return obj;
    }
    
    public CodeMarketing update(CodeMarketing obj) {
  	  super.update(new Code(obj.getIdCode(),obj.getValeur()));
  	  try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery("UPDATE CodeMarketing SET valeur = '"+obj.getValeur()+
					"' where code = '"+obj.getIdCode()+"'");
			stmt.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}	  
		return obj;
    }
}
