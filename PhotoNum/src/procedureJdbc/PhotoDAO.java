package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.models.*;

public class PhotoDAO extends DAO<Photo>{

	@Override
	public Photo find(long id) throws SQLException {
		Photo photo = null;

		Statement stmt = conn.createStatement();
		String query = "Select * from Photo where idPhoto = "+id+"";
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()){
			ImageDAO imgd = new ImageDAO();
			photo = new Photo(imgd.find(rs.getString(2)),rs.getInt(3),rs.getString(4));
			photo.setId((int)id);
		}else {
			System.out.println("Cette photo n'hexiste pas");
		}
		rs.close();
		stmt.close();

		return photo;
	}
	@Override
	public Photo find(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Photo create(Photo obj) throws SQLException {
		int idPhoto = 0;
		Statement stmt = conn.createStatement();
		ResultSet rs;
		rs = stmt.executeQuery("select max(idPhoto) from Photo");
		while(rs.next()) {
			idPhoto=rs.getInt(1);
		}
		idPhoto = idPhoto+1;
		stmt.executeUpdate("INSERT INTO Photo VALUES ("+idPhoto+",'"+obj.getImg().getChemin()+"','"+obj.getResolution()+"','"+obj.getParametre()+"')");
		obj.setId(idPhoto);;
		rs.close();
		stmt.close();
		return obj;
	}

	@Override
	public Photo update(Photo obj) throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Update Photo SET chemin = '"+obj.getImg().getChemin()+""
				+ ", resolution = "+obj.getResolution()+" ,parametre = '"+obj.getParametre()+" where idPhoto = "+obj.getId()+")");
		stmt.close();
		conn.commit();

		return obj;
	}

	@Override
	public void delete(Photo obj) throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DELETE FROM Photo WHERE idPhoto = "+obj.getId()+"");
		stmt.close();
		conn.commit();
	}

}
