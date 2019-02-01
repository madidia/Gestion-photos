package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.models.Code;

public class CodeDAO extends DAO <Code>{
	@Override
	public Code find(String id) throws SQLException {
		Code code = null;
		 
			String c="";
			int valeur=0;
			
			Statement stmt = conn.createStatement();
			String query = "Select * from Code where code = '"+id+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				c=rs.getString(1);
				valeur=rs.getInt(2);
				code=new Code(c, valeur);
			}
			
			rs.close();
			stmt.close();
		
		return code;
	}

	@Override
	public Code find(long id) {
		return null;
	}

	@Override
	public Code create(Code obj) throws SQLException {
		 
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Insert into Code VALUES('"+obj.getIdCode()+"','"+
					obj.getValeur()+"','"+obj.getUtilise()+"')");
			stmt.close();
			conn.commit();
		
		return obj;
	}

	@Override
	public Code update(Code obj) throws SQLException {
		 
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Update Code SET valeur ='"+obj.getValeur()+
					"' where code = '"+obj.getIdCode()+"'");
			stmt.close();
			conn.commit();
		
		return obj;
	}

	@Override
	public void delete(Code obj) throws SQLException {
		 
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE ON Code WHERE code = '"+obj.getIdCode()+"'");
			stmt.close();
			conn.commit();
			
	}

}