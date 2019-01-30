package procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Code;

public class CodeDAO extends DAO <Code>{
	@Override
	public Code find(String id) {
		Code code = null;
		try {
			String c="";
			int valeur=0;
			
			Statement stmt = conn.createStatement();
			String query = "Select * from Code where code = '"+id+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				c=rs.getString(1);
				valeur=rs.getInt(2);
			}
			code=new Code(c, valeur);
			rs.close();
			stmt.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
	}

	@Override
	public Code find(long id) {
		return null;
	}

	@Override
	public Code create(Code obj) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Insert into Code VALUES('"+obj.getIdCode()+"','"+obj.getValeur()+"')");
			stmt.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Code update(Code obj) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Update Code SET valeur ='"+obj.getValeur()+
					"' where code = '"+obj.getIdCode()+"'");
			stmt.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(Code obj) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE ON Code WHERE code = '"+obj.getIdCode()+"'");
			stmt.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}