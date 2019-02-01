package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.models.Commande;
import src.models.Impression;
import src.models.Support;

public class ImpressionDAO extends DAO<Impression>{
	@Override
	public Impression find(String id) {
		return null;
	}

	public void addImpressions(ArrayList<Impression> imps,Commande c) throws SQLException{
		ImpressionDAO impdao = new ImpressionDAO();
		for(int i=0;i<c.getImpressions().size();i++) {
			System.out.println("nb imp" +c.getImpressions().size());
			System.out.println("yyye1");

			impdao.create(imps.get(i));
		}	
	}
	@Override
	public Impression find(long id) throws SQLException {
		id = (int) id;
		Impression imp  = null;
	   	Statement stmt;
		 
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
	    	  SupportDAO sdao = new SupportDAO();
		    	
	    	  Support s=sdao.find(typeSupport+"-"+formatSupport+"-"+qualiteSupport);
	    	  CommandeDAO cdao= new CommandeDAO();
	    	  Commande c=cdao.find(numc);
	    	  imp = new Impression(format, qualite, nb, c,s);
	    	}else{
	    		System.out.println("Cette impression n'hexiste pas");
	    	}
	    	
	    	rs.close();
	    	stmt.close();
		
		return imp;
	}

	@Override
	public Impression create(Impression obj) throws SQLException {
		ResultSet rs=null;
		    
			   int numImp=0;
			   Statement stmt = conn.createStatement();
			   conn.setAutoCommit(false);
			   conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			   rs = stmt.executeQuery("select max(idImpression) from impression");
				while(rs.next()) {
					numImp=rs.getInt(1);
				}
				numImp = numImp+1;
		 	    stmt.executeUpdate("INSERT INTO Impression Values ('"+numImp+"','"+obj.getFormat()+"','"+
		 	    		obj.getQualite()+ "',"+obj.getNbExemplaire()+","+obj.getCmd().getId()+",'"+
		 	    		obj.getSupport().getFormat()+"','"+obj.getSupport().getQualite()+"','"+
		 	    		obj.getSupport().getType()+"')");
		 	    obj.getCmd().getImpressions().add(obj);
		 	    obj.setId(numImp);
		 	    rs.close();
		 	    stmt.close();
		 	    conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
				conn.commit();	 	  
		   	
		   return obj; 
	}

	@Override
	public Impression update(Impression obj) throws SQLException {
		 
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			stmt.executeUpdate("Update Impression SET idImpression ='"+obj.getId()+
					"' ,format ='"+obj.getFormat()+"',qualite ='"+obj.getQualite()+
					"' ,nbExemplaire ='"+obj.getNbExemplaire()+
					"' WHERE idImpression = '"+obj.getId()+"'");
			stmt.close();
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			conn.commit();
		
		return obj;
	}

	@Override
	public void delete(Impression obj) throws SQLException {
		 
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			stmt.executeUpdate("DELETE from Impression where idImpression = '"+obj.getId()+"'");
			stmt.close();
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			conn.commit();
		
	}

}
