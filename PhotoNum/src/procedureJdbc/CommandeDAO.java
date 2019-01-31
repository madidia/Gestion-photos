package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.models.Client;
import src.models.CodePersonnel;
import src.models.Commande;

/***
 * quand on utilise un code je n'arrive pas à le supprimer "mutating table"
 *  *
 */
public class CommandeDAO extends DAO<Commande>{

	@Override
	public Commande create(Commande cmd) throws SQLException {
		int numeroCommande=0;
		Statement stmt=null;
		ResultSet rs=null;
		conn.setAutoCommit(false);
		conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			/** recuperer l'id max dans commande **/
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select max(numCommande) from commande");
			while(rs.next()) {
				   numeroCommande=rs.getInt(1);
				   System.out.println("max id commande" +numeroCommande);
			}
			numeroCommande = numeroCommande+1;
			System.out.println("new id commande " +numeroCommande);
			/** si le client a utilisé un code, alors déduire le montant de la commande **/
			double montant=cmd.getMontant();
			/** si il utilise un code */
			if(cmd.getCode()!=null) {
				cmd.setMontant(montant-(montant*(cmd.getCode().getValeur())/100));
				System.out.println("code non null");
				stmt.executeUpdate("insert into commande(numCommande,mail,dateComm,idAdresse,montant,code) "
						+ "values("+numeroCommande+",'"+cmd.getClient().getMail()+"',sysdate,"+
						cmd.getAdresseLivraison().getId()+","+cmd.getMontant()+",'"+cmd.getCode().getIdCode()+"')");
				System.out.println("ajout reussi");
				
				
				stmt.executeUpdate("update code set utilise='oui' where code='"+cmd.getCode().getIdCode()+"'");
				
				cmd.getCode().setUtilise("oui");
			}
			else {
				/*** si un code n'est pas utilisé alors inséré null */ 
				
				stmt.executeUpdate("insert into commande(numCommande,mail,dateComm,idAdresse,montant) "
					+ "values("+numeroCommande+",'"+cmd.getClient().getMail()+"',sysdate,"+
					cmd.getAdresseLivraison().getId()+","+cmd.getMontant()+")");
				System.out.println("ajout reussi");
			}
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
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			conn.commit();
						  
		return cmd;
	}
	
	@Override
	public Commande update(Commande obj) throws SQLException {
		 
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			stmt.executeUpdate("Update Commande SET idAdresse ="+obj.getAdresseLivraison().getId()+",statut ='"+
			obj.getStatut()+"',code ='"+obj.getCode().getIdCode()+"',montant ="+
					obj.getMontant()+" where numCommande ="+obj.getId()+" AND statut !='en attente'");
			stmt.close();
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			conn.commit();
		
		return obj;
	}

	@Override
	public void delete(Commande obj) throws SQLException {
		 
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			stmt.executeUpdate("DELETE from Commande WHERE numCommande ='"+obj.getId()+"'");
			stmt.close();
			conn.setTransactionIsolation(conn.TRANSACTION_SERIALIZABLE);
			conn.commit();	
		
	}
	
	public ArrayList<Commande> getAllCommande(Client c) throws SQLException{
		
		Statement stmt = conn.createStatement();
		String query = "Select * from Commande ";
		ResultSet rs = stmt.executeQuery(query);
		Commande cmd=null;
		ArrayList<Commande> cm = new ArrayList<>();
		AdresseDAO adao = new AdresseDAO();
		CodeDAO cdao = new CodeDAO();
		while(rs.next()){
			cmd = new Commande(c, adao.find(rs.getInt(4)), rs.getString(5), cdao.find(rs.getString(7)));
			cm.add(cmd);
		}
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
	public Commande find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
