/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nassim
 */
public class user {
        private int id;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;

	public user(int id, String nom, String cpf, String telephone,
			String email) {
		this.id = id;
		this.nom = nom;
		this.prenom = cpf;
		this.telephone = telephone;
		this.email = email;
	}

	public user(String nom, String prenom, String telephone, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", telephone=" + telephone + ", email=" + email + "]";
	}

	public user() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
