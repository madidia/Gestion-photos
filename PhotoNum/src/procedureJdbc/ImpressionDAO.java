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

	/**
	 * 
	 * @param imps
	 * @throws SQLException
	 */
	public void addImpressions(ArrayList<Impression> imps) throws SQLException{
		ImpressionDAO impdao = new ImpressionDAO();
		for(int i=0;i<imps.size();i++) {
			impdao.create(imps.get(i));
		}
		System.out.println("yyye "+imps.size());
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
			System.out.println("Cette impression n'existe pas");
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
		rs = stmt.executeQuery("select max(idImpression) from impression");
		while(rs.next()) {
			numImp=rs.getInt(1);
		}
		numImp = numImp+1;
		Support supp = obj.getSupport();
		SupportDAO sdao = new SupportDAO();
		stmt.executeUpdate("INSERT INTO Impression Values ('"+numImp+"','"+obj.getFormat()+"','"+
				obj.getQualite()+ "',"+obj.getNbExemplaire()+","+obj.getCmd().getId()+",'"+
				obj.getSupport().getFormat()+"','"+obj.getSupport().getQualite()+"','"+
				obj.getSupport().getType()+"')");
		obj.setId(numImp);
		/** mettre a jour le stock dans support */
		supp=sdao.find(supp.getType()+"-"+supp.getFormat()+"-"+supp.getQualite());
		supp.setQuantite((supp.getQuantite()-obj.getNbExemplaire()));
		sdao.update(supp);
		rs.close();
		stmt.close();
		conn.commit();
		return obj; 
	}

	@Override
	public Impression update(Impression obj) throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Update Impression SET idImpression ='"+obj.getId()+
				"' ,format ='"+obj.getFormat()+"',qualite ='"+obj.getQualite()+
				"' ,nbExemplaire ='"+obj.getNbExemplaire()+
				"' WHERE idImpression = '"+obj.getId()+"'");
		Support supp=obj.getSupport();
		SupportDAO sdao = new SupportDAO();
		supp = sdao.find(supp.getType()+"-"+supp.getFormat()+"-"+supp.getQualite());
		supp.setQuantite(supp.getQuantite()-obj.getNbExemplaire());
		sdao.update(supp);
		stmt.close();
		conn.commit();
		return obj;
	}

	@Override
	public void delete(Impression obj) throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DELETE from Impression where idImpression = '"+obj.getId()+"'");
		stmt.close();
		conn.commit();
	}

}
