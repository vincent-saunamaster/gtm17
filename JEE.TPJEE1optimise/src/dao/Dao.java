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

			Connection con = DaoConnection.getConnection();
			// 3 - cr�er requ�te
			// The hard way
			PreparedStatement ps = con.prepareStatement("INSERT INTO client(nom,prenom,couleuryeux,age) values ('"
					+ c.getNom() + "','" + c.getPrenom() + "','" + c.getCouleurYeux() + "','" + c.getAge() + "')");
			/*
			 * Avec des ?, les String se voient automatiquement ajouter les
			 * guillements dans SQL !!!! PreparedStatement ps =
			 * con.prepareStatement(
			 * "INSERT INTO Client(nom,prenom,couleuryeux,age) values ('?,?,?,?')"
			 * ); ps.setString(1, c.getNom()); ps.setString(2, c.getPrenom());
			 * ps.setString(3, c.getCouleurYeux()); ps.setInt(4, c.getAge());
			 * 
			 */
			// 4 - executer requ�te
			ps.executeUpdate();
			// 5 - pr�senter r�sultats

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fonction finally permet de faire ce qu'il y a entre ses accolades
			// quelque soit le r�sultat du try catch

			// 6 - fermer la connexion (peut se faire dans finally, optionnel
			// depuis derni�re version de connection
			DaoConnection.closeConnection();
		}

	}

	@Override
	public void modifierClient(int id, String nom, String prenom, String couleurYeux, int age) {
		// TODO Auto-generated method stub

		try {

			Connection con = DaoConnection.getConnection();
			// 3 - cr�er requ�te
			PreparedStatement ps = con.prepareStatement(
					// requ�te pr�par�e avec ? �tant remplac�s ensuite
					"UPDATE client SET nom = ? , prenom = ? , couleuryeux = ? , age = ? WHERE id = ?");
			// on remplace les ? de la requ�te, les String se voient ajouter les
			// guillemets simples
			ps.setString(1, nom);
			ps.setString(2, prenom);
			ps.setString(3, couleurYeux);
			ps.setInt(4, age);
			ps.setInt(5, id);
			// 4 - executer requ�te
			ps.executeUpdate();
			// 5 - pr�senter r�sultats
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fonction finally permet de faire ce qu'il y a entre ses accolades
			// quelque soit le r�sultat du try catch

			// 6 - fermer la connexion (peut se faire dans finally, optionnel
			// depuis derni�re version de connection
			DaoConnection.closeConnection();
		}

	}

	@Override
	public void supprimerClient(int id) {
		// TODO Auto-generated method stub

		try {

			Connection con = DaoConnection.getConnection();
			// 3 - cr�er requ�te
			PreparedStatement ps = con.prepareStatement("DELETE FROM client WHERE id = ?");
			ps.setInt(1, id);
			// 4 - executer requ�te
			ps.executeUpdate();
			// 5 - pr�senter r�sultats

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fonction finally permet de faire ce qu'il y a entre ses accolades
			// quelque soit le r�sultat du try catch

			// 6 - fermer la connexion (peut se faire dans finally, optionnel
			// depuis derni�re version de connection
			DaoConnection.closeConnection();
		}

	}

	@Override
	public Collection<Client> listerClient() {
		// TODO Auto-generated method stub

		Collection<Client> cl = new ArrayList<>();
		try {

			Connection con = DaoConnection.getConnection();
			// 3 - cr�er requ�te
			PreparedStatement ps = con.prepareStatement("SELECT * FROM client ORDER BY id");
			// 4 - executer requ�te
			ResultSet rs = ps.executeQuery();
			// 5 - pr�senter r�sultats
			// rs contient le tableau renvoy� par select (r�sultat de la
			// requ�te)
			while (rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setCouleurYeux(rs.getString("couleuryeux"));
				c.setAge(rs.getInt("age"));
				cl.add(c);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fonction finally permet de faire ce qu'il y a entre ses accolades
			// quelque soit le r�sultat du try catch

			// 6 - fermer la connexion (peut se faire dans finally, optionnel
			// depuis derni�re version de connection
			DaoConnection.closeConnection();
		}
		return cl;
	}

	@Override
	public Collection<Client> chercherParcMC(String motCle) {
		// TODO Auto-generated method stub
		Collection<Client> cl = new ArrayList<>();
		try {

			Connection con = DaoConnection.getConnection();
			// 3 - cr�er requ�te
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM client WHERE nom LIKE ? OR prenom LIKE ? ORDER BY id");
			ps.setString(1, "%" + motCle + "%");
			ps.setString(2, "%" + motCle + "%");
			// 4 - executer requ�te
			ResultSet rs = ps.executeQuery();
			// 5 - pr�senter r�sultats
			// rs contient le tableau renvoy� par select (r�sultat de la re�te)
			while (rs.next()) {
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setCouleurYeux(rs.getString("couleuryeux"));
				c.setAge(rs.getInt("age"));
				cl.add(c);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fonction finally permet de faire ce qu'il y a entre ses accolades
			// quelque soit le r�sultat du try catch

			// 6 - fermer la connexion (peut se faire dans finally, optionnel
			// depuis derni�re version de connection
			DaoConnection.closeConnection();
		}
		return cl;
	}

	@Override
	public Client chercherClient(int id) {
		// TODO Auto-generated method stub
		Client c = new Client();
		try {

			Connection con = DaoConnection.getConnection();
			// 3 - cr�er requ�te
			PreparedStatement ps = con.prepareStatement("SELECT * FROM client WHERE id = ?");
			ps.setInt(1, id);
			// 4 - executer requ�te
			ResultSet rs = ps.executeQuery();
			// 5 - pr�senter r�sultats
			// rs contient le tableau renvoy� par select (r�sultat de la
			// requ�te)
			rs.next();
			c.setId(rs.getInt("id"));
			c.setNom(rs.getString("nom"));
			c.setPrenom(rs.getString("prenom"));
			c.setCouleurYeux(rs.getString("couleuryeux"));
			c.setAge(rs.getInt("age"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fonction finally permet de faire ce qu'il y a entre ses accolades
			// quelque soit le r�sultat du try catch

			// 6 - fermer la connexion (peut se faire dans finally, optionnel
			// depuis derni�re version de connection
			DaoConnection.closeConnection();
		}
		return c;

	}

}
