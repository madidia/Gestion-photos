package main;

import java.io.Console;
import java.text.ParseException;

import connexion.Connexion;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connexion.getConnection();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
