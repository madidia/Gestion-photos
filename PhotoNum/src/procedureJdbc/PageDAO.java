package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.models.Page;

public class PageDAO extends DAO<Page>{
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
			int idpage=0,numPage=0,numImp=0;
			
			String query = "Select * from Pge where idPage = '"+id+"'";
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				idpage=rs.getInt(1);
				numPage=rs.getInt(2);
				numImp=rs.getInt(3);
				ImpressionDAO impd = new ImpressionDAO();
				page = new Page(numPage,impd.find(numImp));
				page.setId(idpage);
			}
			stmt.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public Page create(Page obj) {
		try {
			int numPage = 0;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(idPage) from Pge");
			while(rs.next()) {
				   numPage=rs.getInt(1);
				   System.out.println("max id Page" +numPage);
			}
			numPage = numPage+1;
			stmt.executeUpdate("Insert into Pge VALUES("+numPage+","+obj.getNumero()+","+obj.getImp().getId()+")");
			obj.setId(numPage);
			stmt.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Page update(Page obj) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Update Pge SET numPage ='"+obj.getNumero()+"' where idPage = '"+obj.getId()+"'");
			
			stmt.close();
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(Page obj) {
		try {
			Statement stmt = conn.createStatement();
			String query = "DELETE FROM Pge WHERE idPage = '"+obj.getId()+"'";
			stmt.executeQuery(query);
			stmt.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public Page saisir() {
		// TODO Auto-generated method stub
		return null;
	}
}
