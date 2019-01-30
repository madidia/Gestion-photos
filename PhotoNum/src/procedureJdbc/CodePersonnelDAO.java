package procedureJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Code;
import models.CodePersonnel;

public class CodePersonnelDAO extends CodeDAO{
    public CodePersonnel find(String x) {
        CodePersonnel cp =  null;
        Statement stmt;
        try {
      	  stmt = conn.createStatement();
      	  String mail="",code="";
      	  int valeur=0;
          String query = "Select * from CodePersonnel where CodeCP = '"+x+"'";
      	  ResultSet rs = stmt.executeQuery(query);
      	  if(rs.next()){
      		  code=rs.getString(1);
      		  valeur=rs.getInt(2);
      		  mail=rs.getString(3);
      	  }
      	  cp = new CodePersonnel(code, valeur, mail);
      	  rs.close();
      	  stmt.close();
      	  conn.commit();
        }
        catch(SQLException e1) {
      	  e1.printStackTrace();
        }
  	  return cp;  
      }
      
      public CodePersonnel create(CodePersonnel obj) {
    	  super.create(new Code(obj.getIdCode(),obj.getValeur()));
    	  try {
  			Statement stmt = conn.createStatement();
  			stmt.executeUpdate("Insert into CodePersonnel Values('"+obj.getIdCode()+"',"+obj.getValeur()+",'"+obj.getMail()+"')");
  			///// ajouter un code pour le client correspondant
  			ClientDAO cdao = new ClientDAO();
  			cdao.find(obj.getMail()).getListCode().add(obj);
  			stmt.close();
  			conn.commit();			
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  		return obj;
      }
      
      public CodePersonnel update(CodePersonnel obj) {
    	  super.update(new Code(obj.getIdCode(),obj.getValeur()));
    	  try {
    		  Statement stmt = conn.createStatement();
    		  stmt.executeUpdate("Update CodePersonnel SET valeurCP='"+obj.getValeur()
    		  	+"',mailCP ='"+obj.getMail()+"' WHERE CodeCP ='"+obj.getIdCode()+"'");
    		  stmt.close();
    		  conn.commit();
    	  } catch (SQLException e) {
    		  e.printStackTrace();
    	  }
  		  return obj;
    }
}