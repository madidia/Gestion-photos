package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import src.models.Adresse;
import src.models.Client;
import src.models.CodePersonnel;
import src.models.Commande;
import src.models.Code;

public class CommandeDAO extends DAO<Commande>{
	@Override
	public Commande create(Commande cmd ) throws SQLException {
		int numeroCommande=0;
		Statement stmt=null;
		ResultSet rs=null;

		/** recuperer l'id max dans commande **/
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select max(numCommande) from commande");
		while(rs.next()) {
			numeroCommande=rs.getInt(1);
		}
		numeroCommande = numeroCommande+1;
		/** si le client a utilisé un code, alors déduire le montant de la commande **/

		/** si il utilise un code */
		if(cmd.getCode()!=null) {
			cmd.setMontant(cmd.getMontant()-(cmd.getMontant()*(cmd.getCode().getValeur())/100));
			System.out.println("code non null");
			stmt.executeUpdate("insert into commande(numCommande,mail,dateComm,idAdresse,montant,code) "
					+ "values("+numeroCommande+",'"+cmd.getClient().getMail()+"',sysdate,"+
					cmd.getAdresseLivraison().getId()+","+cmd.getMontant()+",'"+cmd.getCode().getIdCode()+"')");
			stmt.executeUpdate("update code set utilise='oui' where code='"+cmd.getCode().getIdCode()+"'");

			cmd.getCode().setUtilise("oui");
		}
		else {
			/*** si un code n'est pas utilisé alors inséré null */ 

			stmt.executeUpdate("insert into commande(numCommande,mail,dateComm,idAdresse,montant) "
					+ "values("+numeroCommande+",'"+cmd.getClient().getMail()+"',sysdate,"+
					cmd.getAdresseLivraison().getId()+","+cmd.getMontant()+")");
		}
		cmd.setStatut("en attente");
		/** mettre a jour l'id de la commande **/
		cmd.setId(numeroCommande);
		/** si la commande est superieure a 100 alors creer un code **/
		if(cmd.getMontant()>100) {
			CodePersonnel c = new CodePersonnel("", 5,cmd.getClient().getMail());
			String moncode=c.genererCode();
			CodePersonnelDAO cpdao = new CodePersonnelDAO();
			c.setIdCode(moncode);
			cpdao.create(c);
		}	
		rs.close();
		stmt.close();
		conn.commit();

		return cmd;
	}

	@Override
	public Commande update(Commande obj) throws SQLException {

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Update Commande SET idAdresse ="+obj.getAdresseLivraison().getId()+",statut ='"+
				obj.getStatut()+"',montant ="+
				obj.getMontant()+" where numCommande ="+obj.getId()+" AND statut !='en attente'");
		stmt.close();
		conn.commit();

		return obj;
	}

	@Override
	public void delete(Commande obj) throws SQLException {

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DELETE from Commande WHERE numCommande ='"+obj.getId()+"'");
		stmt.close();
		conn.commit();	

	}

	/**
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Commande> getAllCommande(Client c) throws SQLException{

		Statement stmt = conn.createStatement();
		String query = "Select * from Commande where mail='"+c.getMail()+"'";
		ResultSet rs = stmt.executeQuery(query);
		Commande cmd=null;
		ArrayList<Commande> cm = new ArrayList<>();
		AdresseDAO adao = new AdresseDAO();
		CodeDAO cdao = new CodeDAO();
		while(rs.next()){			
			cmd = new Commande(c, adao.find(rs.getInt(4)), cdao.find(rs.getString(7)));
			cmd.setMontant(rs.getDouble(6));
			cmd.setId(rs.getInt(1));
			cm.add(cmd);
		}
		c.setListCommande(cm);
		stmt.close();
		rs.close();
		return cm;

	}


	@Override
	public Commande find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande find(long id) throws SQLException {
		Statement stmt;
		Commande cmd = null;
		stmt = conn.createStatement();
		String query1 = "Select * from Commande where numCommande = "+id;
		ResultSet rs = stmt.executeQuery(query1);
		ClientDAO cdao = new ClientDAO();
		Client clt;
		AdresseDAO adao = new AdresseDAO();
		Adresse adr;
		CodeDAO cod = new CodeDAO();
		Code code ;
		String mail;
		if(rs.next()) {
			mail=rs.getString(2);
			clt=cdao.find(mail);
			adr=adao.find(rs.getInt(4));
			code=cod.find(rs.getString(7));
			cmd = new Commande(clt, adr, code);
			cmd.setId(rs.getInt(1));
		}else {
			System.out.println("Vos identifiants sont incorrects");
		}
		rs.close();
		stmt.close();

		return cmd;
	}

}
