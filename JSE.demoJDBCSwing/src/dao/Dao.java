package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import metier.Client;

public class Dao implements IDao {

	@Override
	public void ajouterClient(Client c) {
		// TODO Auto-generated method stub

		try {
			// 1 - charger pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2 - créer connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root", "");
			// 3 - créer requête
			// The hard way
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO Client(nom,prenom,couleuryeux) values ('" + c.getNom() + "','" + c.getPrenom() + "','" + c.getCouleurYeux() + "')");
			/* Avec des ?, les String se voient automatiquement ajouter les guillements dans SQL !!!!
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO Client(nom,prenom,couleuryeux) values ('?,?')");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getCouleurYeux());

			*/
			// 4 - executer requête
			ps.executeUpdate();
			// 5 - présenter résultats

			// 6 - fermer la connexion (peut se faire dans finally, optionnel
			// depuis dernière version de connection
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fonction finally permet de faire ce qu'il y a entre ses accolades
			// quelque soit le résultat du try catch
		}

	}

	@Override
	public void modifierClient(int id, String nom, String prenom, String couleurYeux) {
		// TODO Auto-generated method stub

		try {
			// 1 - charger pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2 - créer connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root", "");
			// 3 - créer requête
			PreparedStatement ps = con.prepareStatement(
					// requête préparée avec ? étant remplacés ensuite
					"UPDATE Client SET nom = ? , prenom = ? , couleuryeux = ? WHERE id = ?");
			// on remplace les ? de la requête, les String se voient ajouter les guillemets simples
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, couleurYeux);
			ps.setInt(4, id);
			// 4 - executer requête
			ps.executeUpdate();
			// 5 - présenter résultats

			// 6 - fermer la connexion (peut se faire dans finally, optionnel
			// depuis dernière version de connection
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fonction finally permet de faire ce qu'il y a entre ses accolades
			// quelque soit le résultat du try catch
		}

	}

	@Override
	public void supprimerClient(int id) {
		// TODO Auto-generated method stub
		
		try {
			// 1 - charger pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2 - créer connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root", "");
			// 3 - créer requête
			PreparedStatement ps = con.prepareStatement(
					"DELETE FROM Client WHERE id = ?");
			ps.setInt(1, id);
			// 4 - executer requête
			ps.executeUpdate();
			// 5 - présenter résultats

			// 6 - fermer la connexion (peut se faire dans finally, optionnel
			// depuis dernière version de connection
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fonction finally permet de faire ce qu'il y a entre ses accolades
			// quelque soit le résultat du try catch
		}
		
	}

	@Override
	public Collection<Client> listerClient() {
		// TODO Auto-generated method stub

		Collection<Client> cl = new ArrayList<>();
		try {
			// 1 - charger pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2 - créer connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root", "");
			// 3 - créer requête
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Client ORDER BY id");
			// 4 - executer requête
			ResultSet rs = ps.executeQuery();
			// 5 - présenter résultats
			// rs contient le tableau renvoyé par select (résultat de la requête)
			while (rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setCouleurYeux(rs.getString("couleuryeux"));
				cl.add(c);
			}
			// 6 - fermer la connexion (peut se faire dans finally, optionnel
			// depuis dernière version de connection
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fonction finally permet de faire ce qu'il y a entre ses accolades
			// quelque soit le résultat du try catch
		}
		return cl;
	}

	@Override
	public Collection<Client> chercherParcMC(String motCle) {
		// TODO Auto-generated method stub
		Collection<Client> cl = new ArrayList<>();
		try {
			// 1 - charger pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2 - créer connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root", "");
			// 3 - créer requête
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Client WHERE nom LIKE ? OR prenom LIKE ? ORDER BY id");
			ps.setString(1, "%" + motCle + "%");
			ps.setString(2, "%" + motCle + "%");
			// 4 - executer requête
			ResultSet rs = ps.executeQuery();
			// 5 - présenter résultats
			// rs contient le tableau renvoyé par select (résultat de la reête)
			while (rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setCouleurYeux(rs.getString("couleuryeux"));
				cl.add(c);
			}
			// 6 - fermer la connexion (peut se faire dans finally, optionnel
			// depuis dernière version de connection
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fonction finally permet de faire ce qu'il y a entre ses accolades
			// quelque soit le résultat du try catch
		}
		return cl;
	}

	@Override
	public Client chercherClient(int id) {
		// TODO Auto-generated method stub
		Client c = new Client();
		try {
			// 1 - charger pilote
			Class.forName("com.mysql.jdbc.Driver");
			// 2 - créer connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root", "");
			// 3 - créer requête
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Client WHERE id = ?");
			ps.setInt(1, id);
			// 4 - executer requête
			ResultSet rs = ps.executeQuery();
			// 5 - présenter résultats
			// rs contient le tableau renvoyé par select (résultat de la requête)
			rs.next();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setCouleurYeux(rs.getString("couleuryeux"));
			// 6 - fermer la connexion (peut se faire dans finally, optionnel
			// depuis dernière version de connection
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fonction finally permet de faire ce qu'il y a entre ses accolades
			// quelque soit le résultat du try catch
		}
		return c;
	
	}

}
