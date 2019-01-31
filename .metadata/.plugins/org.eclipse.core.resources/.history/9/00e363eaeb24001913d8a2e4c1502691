package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.models.Support;

public class SupportDAO extends DAO<Support>{
	@Override
	public Support find(String id) {
		String [] idS = id.split("-");
		String typeid = idS[0];
		String formatid = idS[1];
		String qualiteid = idS[2];
		Statement stmt;
		Support supp = null;
		try {
			String type="",format="",qualite="";
			int qte=0;
			double pu=0;
			stmt = conn.createStatement();
			String query = "Select * from Support where type ='"+typeid+"' and format ='"+formatid+"' and qualite='"+qualiteid+"' ";
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()){
				type=rs.getString(1);
				format=rs.getString(2);
				qualite=rs.getString(3);
				qte=rs.getInt(4);
				pu=rs.getInt(5);
			}
			supp = new Support(type, format, qualite, qte, pu);
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supp;
	}

	@Override
	public Support find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Support create(Support obj) {
		
		try {
			Statement stmt = conn.createStatement();
			String query = "Insert into Support Values('"+obj.getType()+"','"+obj.getFormat()+"',"
					+ "'"+obj.getQualite()+"',"+obj.getQuantite()+","+obj.getPrix()+")";
			
			stmt.executeUpdate(query);
			stmt.close();
		 	conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	 	 
	}

	@Override
	public Support update(Support obj) {
		try {
			Statement stmt = conn.createStatement();
			String query = "Update Support SET type ='"+obj.getType()+"',format = '"+obj.getFormat()+
					"',qualite ='"+obj.getQualite()+"',quantite ='"+obj.getQuantite()+
					",pu ='"+obj.getPrix()+"' where format ='"+obj.getFormat()+
					"' AND qualite ='"+obj.getQualite()+"' AND type ='"+obj.getType()+"'";
			stmt.executeUpdate(query);
			stmt.close();
			conn.commit();
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(Support obj) {
		try {
		Statement stmt = conn.createStatement();	
		stmt.executeUpdate("DELETE from Support WHERE type ='"+obj.getType()+
				"' AND format ='"+obj.getFormat()+"'AND qualite = '"+obj.getQualite()+"'");
		stmt.close();
		conn.commit();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
