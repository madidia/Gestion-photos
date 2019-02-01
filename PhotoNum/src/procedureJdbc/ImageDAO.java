package src.procedureJdbc;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.models.Image;

public class ImageDAO extends DAO<Image>{
	@Override
	public Image find(String id) throws SQLException {
		this.ProcedureImg();
		Image img = null;
		ClientDAO clt = new ClientDAO();
			Statement stmt = conn.createStatement();
			String query = "Select * from Img where chemin = '"+id+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				img = new Image(rs.getString(1),clt.find(rs.getString(2)),rs.getInt(3),rs.getString(4));	
			}else {
				System.out.println("Cette image n'hexiste pas");
			}
		rs.close();
		stmt.close();
		return img;
	}

	@Override
	public Image find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image create(Image obj) throws SQLException {
		this.ProcedureImg();
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Insert into Img VALUES('"+obj.getChemin()
				+"','"+obj.getProprio().getMail()+"',"+obj.getResolution()+",'"+obj.isPartage()+"',sysdate)");
			stmt.close();
			conn.commit();
		return obj;
	}

	@Override
	public Image update(Image obj) throws SQLException {
		this.ProcedureImg();
		 
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Update Img SET mail = '"+obj.getProprio().getMail()+"',"
				+ "resolution ="+obj.getResolution()+",partagee ='"+obj.isPartage()+"'"
				+ ",dateDerniereUtilisation = sysdate where chemin = '"+obj.getChemin()+"'");
		stmt.close();
		conn.commit();
		
		return obj;
	}

	@Override
	public void delete(Image obj) throws SQLException {
		this.ProcedureImg();
		 
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("DELETE from Img where chemin = '"+obj.getChemin()+"'");
			stmt.close();
		conn.commit();
		
	}
	
    public void ProcedureImg() throws SQLException {
    	 
			CallableStatement stmt = conn.prepareCall("{call SuppressionImage()}");
			stmt.executeQuery();
		
    }

}
