package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.models.Client;
import src.models.LectureClavier;

public class ClientDAO extends UtilisateurDAO<Client> {

	
	public Client find(String mail,String pwd) throws SQLException {
	   	Statement stmt;
  	    Client clt = null;
		 
			String m="",prenom="",nom="",mdp="";
			stmt = conn.createStatement();
	    	String query1 = "Select * from ClientP where mailC = '"+mail+"' and mdpasseC = '"+pwd+"'";
	    	ResultSet rs = stmt.executeQuery(query1);
	    	if(rs.next()) {
	    		m=rs.getString(1);
	    		nom=rs.getString(2);
	    		prenom=rs.getString(3);
	    		mdp=rs.getString(4);
		    	clt = new Client(m,nom,prenom,mdp);
	    	}else {
	    		System.out.println("Vos identifiants sont incorrects");
	    	}
	    	rs.close();
	    	stmt.close();
		
		return clt;
	}
	
	@Override
	public Client create(Client obj) throws SQLException {
	    
		   Statement stmt = conn.createStatement();
		   String query1 = "Select mailU from Utilisateur where mailU = '"+obj.getMail()+"' ";
		   ResultSet rs = stmt.executeQuery(query1);
		   if(!rs.next()) {
	 		 String query2 = "INSERT INTO Utilisateur Values ('"+obj.getMail()+"')";
	 		 String query3 = "INSERT INTO ClientP Values ('"+obj.getMail()+"','"+obj.getNom()+"','"+obj.getPrenom()+"','"+obj.getPassword()+"')";
	 		 stmt.executeQuery(query2);
	 		 stmt.executeQuery(query3);
	 		 System.out.println("Votre compte a été créé avec succès");
	 		 rs.close();
	 		 stmt.close();
	 		 conn.commit();
	 		 return obj;
		   } else {
	 		   System.out.println("le mail est d�ja utilis�");
		   }
	   	
	   return null; 
    }
    
	@Override
	public Client update(Client obj) throws SQLException {
		 
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Update ClientP SET nomC ='"+obj.getNom()+"' ,prenomC ='"+
					obj.getPrenom()+"',mdpasseC ='"+obj.getPassword()+"'"
					+ "WHERE mailC ='"+obj.getMail()+"'");
			stmt.close();
			conn.commit();
		
		return obj;
	}

	@Override
	public void delete(Client obj) throws SQLException {
		 
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE from ClientP where mailC = '"+obj.getMail()+"'");
			stmt.close();
			conn.commit();
		
	}

	@Override
	public Client find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client saisir() throws SQLException {
		String nom,prenom,email,mdp;
		//----------------------nom----------------------
        System.out.println("Veuillez saisir votre nom :");
        nom=LectureClavier.lireChaine();
        //----------------------prenom----------------------
        System.out.println("Veuillez saisir votre prenom :");
        prenom=LectureClavier.lireChaine();
        //----------------------email----------------------
        System.out.println("Veuillez saisir votre email :");
        email=LectureClavier.lireChaine();
        //----------------------mdp----------------------
        System.out.println("Veuillez saisir votre mot de passe :");
        mdp=LectureClavier.lireChaine();
        Client c = new Client(email, nom, prenom, mdp);
        this.create(c);
		return c;
	}

	public Client seConnecter() throws SQLException {
		String mail,pwd;
		System.out.println("----------------------------------");
        System.out.println("       ESPACE DE CONNEXION        ");
        System.out.println("----------------------------------");
		//----------------------email----------------------
        System.out.println("saisissez votre email :");
        mail=LectureClavier.lireChaine();
        //----------------------mdp----------------------
        System.out.println("saisissez votre mot de passe :");
        pwd=LectureClavier.lireChaine();
        return this.find(mail, pwd);
	}
	@Override
	public Client find(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
