package procedureJdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Commande;
import models.Impression;
import models.Support;

public class ImpressionDAO extends DAO<Impression>{
    public Connection conn;
	@Override
	public Impression find(String id) {
		return null;
	}

	@Override
	public Impression find(long id) {
		id = (int) id;
		Impression imp  = null;
	   	Statement stmt;
		try {
			stmt = conn.createStatement();
			int nb=0,numc=0;
			String format="",qualite="";
			String typeSupport="",formatSupport="",qualiteSupport="";
	    	String query1 = "Select * from Impression where idImpression = '"+id+"' ";
	    	ResultSet rs = stmt.executeQuery(query1);
	    	if(rs.next()){
	    	  format=rs.getString(2);
	    	  qualite=rs.getString(3);
	    	  nb=rs.getInt(4);
	    	  numc=rs.getInt(5);
	    	  formatSupport=rs.getString(6);
	    	  qualiteSupport=rs.getString(7);
	    	  typeSupport=rs.getString(8);
	    	  
	    	}
	    	SupportDAO sdao = new SupportDAO();
	    	
	    	Support s=sdao.find(typeSupport+"-"+formatSupport+"-"+qualiteSupport);
	    	
	    	CommandeDAO cdao= new CommandeDAO();
	    	Commande c=cdao.find(numc);
	    	
	    	imp = new Impression(format, qualite, nb, c,s);
	    	
	    	rs.close();
	    	stmt.close();
	    	conn.commit();
	    	conn.close();
	    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return imp;
	}

	@Override
	public Impression create(Impression obj) {
		ResultSet rs=null;
		   try {
			   int numImp=0;
			   Statement stmt = conn.createStatement();
			   rs = stmt.executeQuery("select max(idImpression) from impression");
				while(rs.next()) {
					numImp=rs.getInt(1);
				}
				numImp = numImp+1;
		 	    stmt.executeUpdate("INSERT INTO Impression Values ('"+numImp+"','"+obj.getFormat()+"','"+
		 	    		obj.getQualite()+ "',"+obj.getNbExemplaire()+","+obj.getCmd().getId()+",'"+
		 	    		obj.getSupport().getFormat()+"','"+obj.getSupport().getQualite()+"','"+
		 	    		obj.getSupport().getType()+"')");
		 	    obj.setId(numImp);
		 	    rs.close();
		 	    stmt.close();
		 	    conn.commit();
		 	    conn.close();		 	  
		   	} catch (SQLException e) {
		   		e.printStackTrace();
		   	}
		   return obj; 
	}

	@Override
	public Impression update(Impression obj) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Update Impression SET idImpression ='"+obj.getId()+
					"' ,format ='"+obj.getFormat()+"',qualite ='"+obj.getQualite()+
					"' ,nbExemplaire ='"+obj.getNbExemplaire()+
					"' WHERE idImpression = '"+obj.getId()+"'");
			stmt.close();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(Impression obj) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE from Impression where idImpression = '"+obj.getId()+"'");
			stmt.close();
			conn.commit();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
}
