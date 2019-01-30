package procedureJdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Image;

public class ImageDAO extends DAO<Image>{
    private Connection conn;
	@Override
	public Image find(String id) {
		this.ProcedureImg();
		Image img = null;
		try {
			Statement stmt = conn.createStatement();
			String query = "Select * from Image where chemin = '"+id+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
			{
				img = new Image(rs.getString(1),rs.getInt(3),rs.getString(2),Boolean.parseBoolean(rs.getString(4)));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return img;
	}

	@Override
	public Image find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image create(Image obj) {
		this.ProcedureImg();
		try {
			Statement stmt = conn.createStatement();
			String query = "Insert into Image VALUES('"+obj.getChemin()+"','"+obj.getMailProprio()+"','"+obj.getResolution()+"','"+obj.isPartage()+""
					+ "'"+obj.getDateDUtilisation()+"')";
			if(this.find(obj.getChemin()) == null) {
				stmt.executeQuery(query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Image update(Image obj) {
		this.ProcedureImg();
		try {
		Statement stmt = conn.createStatement();
		String query = "Update Support mail = '"+obj.getMailProprio()+"',"
				+ "resolution ='"+obj.getResolution()+"',partagee ='"+obj.isPartage()+"'"
				+ ",dateDerniereUtilisation ='"+obj.getDateDUtilisation()+"' where chemin = '"+obj.getChemin()+"'";
		stmt.executeQuery(query);
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(Image obj) {
		this.ProcedureImg();
		try {
			Statement stmt = conn.createStatement();
			String query ="DELETE ON Image where chemin = '"+obj.getChemin()+"')";
			stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public void ProcedureImg() {
    	try {
			CallableStatement stmt = conn.prepareCall("{call SuppressionImage()}");
			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
