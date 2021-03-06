package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.models.Support;

public class SupportDAO extends DAO<Support>{
	@Override
	public Support find(String id) throws SQLException {
		String [] idS = id.split("-");
		String typeid = idS[0];
		String formatid = idS[1];
		String qualiteid = idS[2];
		Statement stmt;
		Support supp = null;
		String type="",format="",qualite="";
		int qte=0;
		double pu=0;
		stmt = conn.createStatement();
		String query = "Select * from Support where type ='"+typeid+"' and format ='"+
				formatid+"' and qualite='"+qualiteid+"' ";
		ResultSet rs = stmt.executeQuery(query);

		if(rs.next()){
			type=rs.getString(1);
			format=rs.getString(2);
			qualite=rs.getString(3);
			qte=rs.getInt(4);
			pu=rs.getInt(5);
			supp = new Support(type, format, qualite, qte, pu);
		}
		stmt.close();
		rs.close();
		return supp;
	}

	@Override
	public Support find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Support create(Support obj) throws SQLException{
		Statement stmt = conn.createStatement();
		String query = "Insert into Support Values('"+obj.getType()+"','"+obj.getFormat()+"',"
				+ "'"+obj.getQualite()+"',"+obj.getQuantite()+","+obj.getPrix()+")";
		stmt.executeUpdate(query);
		stmt.close();
		conn.commit();
		return obj;
	}

	@Override
	public Support update(Support obj) throws SQLException{
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Update Support SET quantiteStock ="+obj.getQuantite()+
				",pu ="+obj.getPrix()+" where format ='"+obj.getFormat()+
				"' AND qualite ='"+obj.getQualite()+"' AND type ='"+obj.getType()+"'");
		stmt.close();
		conn.commit();
		return obj;
	}

	@Override
	public void delete(Support obj) throws SQLException{ 
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DELETE from Support WHERE type ='"+obj.getType()+
				"' AND format ='"+obj.getFormat()+"'AND qualite = '"+obj.getQualite()+"'");
		stmt.close();
		conn.commit();
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Support> getAllSupport() throws SQLException{
		Statement stmt = conn.createStatement();
		String query = "Select * from Support ";
		ResultSet rs = stmt.executeQuery(query);
		Support supp=null;
		ArrayList<Support> s = new ArrayList<>();
		while(rs.next()){
			supp = new Support(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
			s.add(supp);
		}
		stmt.close();
		rs.close();
		return s;
	}

}
