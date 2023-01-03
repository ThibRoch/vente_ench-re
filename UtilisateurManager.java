package fr.eni.BLL;

import java.sql.SQLException;
import java.util.List;

import fr.eni.BO.Utilisateur;
import fr.eni.DAL.UtilisateurDAO;


public class UtilisateurManager {

	private static UtilisateurManager instance = null;
	private UtilisateurDAO utilisateurDAO;

	private UtilisateurManager(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager(UtilisateurDAO.getInstance());
		}
		return instance;
	}

	public Utilisateur login(String email, String password) {
		return UtilisateurDAO.login(email, password);
	}
	
	public void create(Utilisateur user) throws SQLException {
		UtilisateurDAO.create(user);
	}

	/*public void save(Utilisateur utilisateur) {
		utilisateur.setNom(utilisateur.getNom());
		UtilisateurDAOJdbcImpl.save(utilisateur);
	}*/

	public void update(Utilisateur u)  {
		UtilisateurDAO.update(u);
	}
	
	public List<Utilisateur> findAll(String field,String sens) {
		return utilisateurDAO.findAll(field,sens);

	}

	public Utilisateur findByPseudo(String pseudo) {
		return UtilisateurDAO.findByPseudo(pseudo);

	}

	public Utilisateur findByEmail(String email) {
		return UtilisateurDAO.findByEmail(email);
	}

	public void deleteByPseudo(String pseudo) {
			UtilisateurDAO.deleteByPseudo(pseudo);

	}

	public boolean verificationEmail(String email) {
		if (email.contains("@")) {
			return true;
		}

		return false;
	}

	public boolean verifPassword(String password) {
		char mdp;
		boolean numberOK = false;
		boolean lettreOK = false;
		for (int i = 0; i < password.length(); i++) {
			mdp = password.charAt(i);
			if (Character.isDigit(mdp)) {
				numberOK = true;
			} else if (Character.isLetter(mdp)) {
				lettreOK = true;
			}
		}
		return numberOK && lettreOK;
	}
	/*
	 * String mot = mdp;
	 * 
	 * boolean aAuMoinsUneLettre = false; boolean aAuMoinsUnChiffre = false; boolean
	 * lesLettresSontToutesDesMajuscules = true; boolean aUnCaractereSpecial =
	 * false;
	 * 
	 * for (int i=0; i < mot.length(); i++) { char caractereATraiter =
	 * mot.charAt(i);
	 * 
	 * if ( Character.isDigit(caractereATraiter) ) { aAuMoinsUnChiffre = true; }
	 * else if ( Character.isLetter(caractereATraiter) ) { aAuMoinsUneLettre = true;
	 * if ( Character.isLowerCase(caractereATraiter) )
	 * lesLettresSontToutesDesMajuscules = false; } else { aUnCaractereSpecial =
	 * true; } }
	 * 
	 * StringBuilder erreurs = new StringBuilder("Merci d'entrer");
	 * 
	 * boolean aUneErreur = false;
	 * 
	 * if(!aAuMoinsUneLettre) { aUneErreur = true;
	 * erreurs.append(" au moins une lettre\n"); }
	 * 
	 * if(!aAuMoinsUnChiffre) { if(aUneErreur) erreurs.append(","); aUneErreur =
	 * true; erreurs.append(" au moins un chiffre\n"); }
	 * 
	 * if(!lesLettresSontToutesDesMajuscules) { if(aUneErreur) erreurs.append(",");
	 * aUneErreur = true; erreurs.append(" les lettres en majuscules\n"); }
	 * 
	 * if(aUnCaractereSpecial) { if(aUneErreur) erreurs.append(","); aUneErreur =
	 * true; erreurs.append(" uniquement des lettres ou chiffres/n"); }
	 * 
	 * if (aUneErreur == true) throw new ErreurSaisieException (erreurs.toString());
	 * return mot; // si aucune exception est levée on retourne le mot }
	 */
}
