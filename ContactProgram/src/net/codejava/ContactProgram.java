package net.codejava;

import java.sql.*;

public class ContactProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcURL = "jdbc:postgresql://localhost:5432/shopme";
		String username = "postgres";
		String pwd = "okcoral";
		
		try {
			
			Connection connection = DriverManager.getConnection(jdbcURL, username, pwd);
			System.out.println("C'est good connected");
			
			// Insertion d'une ligne définie
			String insertRowEmile = "INSERT INTO contacts (last_name, first_name, email) "
					+ " VALUES ('Feltesse','Emile','emilefeltesse@gmail.com')";
			Statement statement = connection.createStatement();
			int rows = statement.executeUpdate(insertRowEmile);
			if (rows>0) {
				System.out.println("C'est bon Emile est dans la base");
			}
			
			// Insertion d'une ligne dynamique
			String insertRow = "INSERT INTO contacts (last_name, first_name, email) "
					+ " VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertRow);
			preparedStatement.setString(1, "Pipidu");
			preparedStatement.setString(2,"MinceMince");
			preparedStatement.setString(3, "emilefeltesse@gmail.com");
			int row2 = preparedStatement.executeUpdate();
			if (row2>0) {
				System.out.println("C'est bon Pipidu est dans la base");
			}
			
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Erreur de connexion au serveur bim bam boum");
			e.printStackTrace();
			
		}
		

	}

}
