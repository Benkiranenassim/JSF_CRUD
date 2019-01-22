package controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import DAO.UserDAO;
import java.sql.SQLException;
import model.user;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 455659950717243338L;
	private user user = new user();
	private UserDAO userDAO = new UserDAO();
	private List<user> users = new ArrayList<user>();

	public UserBean() {
		users = userDAO.readAll();
	}

	public void inserer(ActionEvent evt) {
		userDAO.create(user);
		users = userDAO.readAll();
		showMessage("utilisateur " + user.getNom() +" est créé avec success!");
	}

	public void atualiser() {
		userDAO.update(user);
		users = userDAO.readAll();
		showMessage("utilisateur " + user.getNom() + " est modifié avec succes!");
	}

	public void remove() {
		userDAO.delete(user.getId());
		users = userDAO.readAll();
		showMessage("utilisateur " + user.getNom() + " est supprimé avec succes!");
	}

	public void nettoyer() {
		user = new user();
	}
	
	private void showMessage(String summary) {
		FacesContext context = FacesContext.getCurrentInstance();  
		context.addMessage(null, new FacesMessage(summary));  
	}

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<user> getUsers() {
        return users;
    }

    public void setUsers(List<user> users) {
        this.users = users;
    }
    	public user getNullUser() {
		return new user();
	}


}
