package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.user;

public class UserDAO {
	private final String URL = "jdbc:mysql://localhost:3306/crud_schema";
	private final String NOM = "root";
	private final String PASSWORD = "";

	private Connection con;
	private Statement comando;

	public void connecter() {
		try {
			con = ConnectionFactory.conexion(URL, NOM, PASSWORD,
					ConnectionFactory.MYSQL);
			comando = con.createStatement();
			System.out.println("Conecté");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur de driver: " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Erreur de connection: " + e.getMessage());
		}
	}

	public void close() {
		try {
			comando.close();
			con.close();
			System.out.println("deconnecté");
		} catch (SQLException e) {
			System.err.println("erreur de connection: " + e.getMessage());
		}
	}

	public void create(user user) {
		connecter();
		try {
			comando.execute("INSERT INTO jsfuser(nom,prenom,phone,email) VALUES('"
					+ user.getNom()
					+ "', '"
					+ user.getPrenom()
					+ "', '"
					+ user.getTelephone() + "', '" + user.getEmail() + "')");
		} catch (SQLException e) {
			System.err.println("Erreur d'insertion " + e.getMessage());
		} finally {
			close();
		}
	}

	public user read(int id) {
		connecter();
		ResultSet rs;
		user temp = null;
		try {
			rs = comando.executeQuery("SELECT * FROM jsfuser WHERE id LIKE '"
					+ id + "%';");
			while (rs.next()) {
				temp = new user(rs.getInt("id"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("phone"),
						rs.getString("email"));
			}
			return temp;

		} catch (SQLException e) {
			System.err.println("Erreur lors de la récupération de l'utilisateur: " + e.getMessage());
		} finally {
			close();
		}
		return null;
	}

	public List<user> readAll() {
		connecter();
		List<user> lista = new ArrayList<user>();
		ResultSet rs;
		user temp = null;
		try {
			rs = comando.executeQuery("SELECT * FROM jsfuser");
			while (rs.next()) {
				temp = new user(rs.getInt("id"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("phone"),
						rs.getString("email"));
				lista.add(temp);
			}
			return lista;
		} catch (SQLException e) {
			System.err.println("erreur de lister: " + e.getMessage());
			return null;
		} finally {
			close();
		}
	}

	public void update(user user) {
		connecter();
		try {
			comando.executeUpdate("UPDATE jsf SET name = '"
					+ user.getNom()+ "', prenom ='" + user.getPrenom()
					+ "', phone = '" + user.getTelephone() + "', email ='"
					+ user.getEmail() + "' WHERE  id = " + user.getId() + ";");
		} catch (SQLException e) {
			System.err.println("erreur de modification: " + e.getMessage());
		} finally {
			close();
		}

	}

	public void delete(int id) {
		connecter();
		try {
			comando.execute("DELETE FROM jsf WHERE id = '" + id + "';");
		} catch (SQLException e) {
			System.err.println("erreur de suppression: " + e.getMessage());
		} finally {
			close();
		}
	}

}
