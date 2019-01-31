package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
						cmd.getAdresse().getId()+","+cmd.getMontant()+",'"+cmd.getCode().getIdCode()+"')");
				System.out.println("ajout reussi");
				
				
				stmt.executeUpdate("update code set utilise='oui' where code='"+cmd.getCode().getIdCode()+"'");
				
				cmd.getCode().setUtilise("oui");
			}
			else {
				/*** si un code n'est pas utilisé alors inséré null */ 
				
				stmt.executeUpdate("insert into commande(numCommande,mail,dateComm,idAdresse,montant) "
					+ "values("+numeroCommande+",'"+cmd.getClient().getMail()+"',sysdate,"+
					cmd.getAdresse().getId()+","+cmd.getMontant()+")");
				System.out.println("ajout reussi");
			}
			/** inserer la commande dans la BD **/
			
			/** mettre a jour l'id de la commande **/
			cmd.setId(numeroCommande);
			rs.close();
			stmt.close();
			/** si la commande est superieure a 100 alors creer un code **/
			if(cmd.getMontant()>100) {
				CodePersonnel c = new CodePersonnel("", 5,cmd.getClient().getMail());
				String moncode=c.genererCode();
				CodePersonnelDAO cpdao = new CodePersonnelDAO();
				c.setIdCode(moncode);
				cpdao.create(c);
			}				
			conn.commit();	
						  
		return cmd;
	}
	
	@Override
	public Commande update(Commande obj) throws SQLException {
		 
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Update Commande SET idAdresse ="+obj.getAdresse().getId()+",statut ='"+
			obj.getStatut()+"',code ='"+obj.getCode().getIdCode()+"',montant ="+
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

	@Override
	public Commande saisir() {
		// TODO Auto-generated method stub
		return null;
	}

}
