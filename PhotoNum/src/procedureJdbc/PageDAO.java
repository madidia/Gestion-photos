package procedureJdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Page;

public class PageDAO extends DAO<Page>{
    private Connection conn;
	@Override
	public Page find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page find(long id) {
		Page page = null;
		try {
			Statement stmt = conn.createStatement();
			String query = "Select * from Page where idPage = '"+id+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next())
			{
				page = new Page(rs.getInt(1),rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public Page create(Page obj) {
		try {
			Statement stmt = conn.createStatement();
			String query = "Insert into Page VALUES('"+obj.getId()+"','"+obj.getNumero()+"')";
			if(this.find(obj.getId()) == null) {
				stmt.executeQuery(query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Page update(Page obj) {
		try {
			Statement stmt = conn.createStatement();
			String query = "Update PageC SET numPage ='"+obj.getNumero()+"' where idPage = '"+obj.getId()+"'";
			stmt.executeQuery(query);
			stmt.close();
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(Page obj) {
		try {
			Statement stmt = conn.createStatement();
			String query = "DELETE ON Page WHERE idPage = '"+obj.getId()+"'";
			stmt.executeQuery(query);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
