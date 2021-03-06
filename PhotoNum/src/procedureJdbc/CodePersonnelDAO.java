package src.procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import src.models.Client;
import src.models.Code;
import src.models.CodePersonnel;

public class CodePersonnelDAO extends CodeDAO{
	public CodePersonnel find(String x) throws SQLException {
		CodePersonnel cp =  null;
		Statement stmt;

		stmt = conn.createStatement();
		String mail="",code="";
		int valeur=0;
		String query = "Select * from CodePersonnel where CodeCP = '"+x+"'";
		ResultSet rs = stmt.executeQuery(query);
		if(rs.next()){
			code=rs.getString(1);
			valeur=rs.getInt(2);
			mail=rs.getString(3);
			cp = new CodePersonnel(code, valeur, mail);
			rs.close();
			stmt.close();
		}else {
			System.out.println("Ce code n'hexiste pas");
		}
		return cp;  
	}
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	public CodePersonnel create(CodePersonnel obj) throws SQLException {
		super.create(new Code(obj.getIdCode(),obj.getValeur()));
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Insert into CodePersonnel Values('"+obj.getIdCode()+"',"+
				obj.getValeur()+",'"+obj.getMail()+"')");
		ClientDAO cdao = new ClientDAO();
		cdao.find(obj.getMail()).getListCode().add(obj);
		stmt.close();
		conn.commit();			
		return obj;
	}

	/**
	 * 
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	public CodePersonnel update(CodePersonnel obj) throws SQLException {
		super.update(new Code(obj.getIdCode(),obj.getValeur()));
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Update CodePersonnel SET valeurCP='"+obj.getValeur()
		+"',mailCP ='"+obj.getMail()+"' WHERE CodeCP ='"+obj.getIdCode()+"'");
		stmt.close();
		conn.commit();
		return obj;
	}

	/**
	 * 
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Code> getMesCodes(Client obj) throws SQLException{
		ArrayList<Code> mesCodes=new ArrayList<>();
		Statement stmt = conn.createStatement();
		String query = "Select * from CodePersonnel where mailCP = '"+obj.getMail()+"'";
		ResultSet rs = stmt.executeQuery(query);
		Code c =null;
		while(rs.next()){
			c = new Code(rs.getString(1), rs.getInt(2));
			mesCodes.add(c);
		}
		query = "Select * from CodeMarketing ";
		ResultSet rs2 = stmt.executeQuery(query);
		while(rs2.next()){
			c = new Code(rs.getString(1), rs.getInt(2));
			mesCodes.add(c);
		}
		rs.close();
		stmt.close();
		obj.setListCode(mesCodes);
		if(mesCodes.size()>0) {
			System.out.println("Vous n avez pas de code reduction");
		}
		return mesCodes;
	}

}
