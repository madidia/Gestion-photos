package src.procedureJdbc;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.models.Client;
import src.models.Image;
import src.models.ResQ;

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

	public ResQ getData(String query) throws SQLException {
		ResQ array = new ResQ();
		ArrayList<Object> row = null;

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		int cols = rs.getMetaData().getColumnCount();

		while (rs.next()) {
			row = new ArrayList<Object>();

			for (int i = 1; i <= cols; i++) {
				row.add(rs.getObject(i));
			}
			array.add(row);
		}
		// Close the result set, statement and the connection
		rs.close();
		stmt.close();

		return array;
	}

	/**
	 * 
	 * @param client
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Image> getClientImages(Client client) throws SQLException {
		String query = "select * from Img where mail='" + client.getMail() + "'";
		System.out.println(query);
		ResQ array = getData(query);
		ArrayList<Image> imageList = new ArrayList<Image>();
		for (ArrayList<Object> row : array) {
			imageList.add(new Image(row.get(0).toString(), client, Double.parseDouble(row.get(2).toString()),
					row.get(2).toString()));
		}
		return imageList;
	}



}
