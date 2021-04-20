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
			
			// Affichage d'un resultset
			String select = "SELECT * from contacts";
			Statement statement = connection.createStatement();
			
			ResultSet result = statement.executeQuery(select);
			
			while (result.next()){
				
				int id = result.getInt("id");
				String nom = result.getString("last_name");
				String prenom = result.getString("first_name");
				String email = result.getString("email");
				
				System.out.printf("%d - %s - %s - %s\n",id ,prenom ,nom ,email);
			}
			

			
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Erreur de connexion au serveur bim bam boum");
			e.printStackTrace();
			
		}
		

	}

}
