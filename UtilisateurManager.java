package fr.eni.eni_encheres.bll;

import java.util.List;

import fr.eni.eni_encheres.bo.Utilisateur;
import fr.eni.eni_encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static UtilisateurManager instance = null;

	private UtilisateurManager(UtilisateurDAO utilisateurDAO) {
	}

	//SINGLETON
	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager(UtilisateurDAO.getInstance());
		}
		return instance;
	}

	//Méthodes métiers
	public Utilisateur login(String email, String pwd) {
		return UtilisateurDAO.login(email, pwd);
	}
	
	public void create(Utilisateur user) {
		UtilisateurDAO.create(user);
	}
	
	public void deleteByPseudo(String pseudo) {
			UtilisateurDAO.deleteByPseudo(pseudo);
	}

	public void update(Utilisateur user)  {
			UtilisateurDAO.update(user);
	}

	public List<Utilisateur> findAll(String field, String sens){
		return UtilisateurDAO.findAll(field,sens);
	}

	public Utilisateur findByPseudo(String pseudo) {
		return UtilisateurDAO.findByPseudo(pseudo);

	}

	public Utilisateur findByEmail(String email) {
		return UtilisateurDAO.findByEmail(email);
	}

	// Vérification des paramètres
	public boolean verificationEmail(String email) {
		if (email.contains("@")) {
			return true;
		}

		return false;
	}

	public boolean verifPassword(String pwd) {
		char mdp;
		boolean numberOK = false;
		boolean lettreOK = false;
		
		for (int i = 0; i < pwd.length(); i++) {
			mdp = pwd.charAt(i);
			
			if (Character.isDigit(mdp))
				numberOK = true;
				
			else if (Character.isLetter(mdp))
				lettreOK = true;
		}
		return numberOK && lettreOK;
	}
}
