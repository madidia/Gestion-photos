package main;

import java.io.Console;
import java.text.ParseException;

import connexion.Connexion;
import models.Client;
import procedureJdbc.ClientDAO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ClientDAO c = new ClientDAO();
			c.conn = Connexion.getConnection();
			Client ac = c.find("mail@gmail.com");
			System.out.println(ac.getPrenom());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
