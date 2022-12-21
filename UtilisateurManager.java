package fr.eni.BLL;

import fr.eni.BO.Utilisateur;
import fr.eni.DAL.UtilisateurDAO;
import fr.eni.DAL.UtilisateurDAOJdbcImpl;

public class UtilisateurManager {

	private static UtilisateurManager instance = null;
	private UtilisateurDAO utilisateurDAO;

	private UtilisateurManager(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}

	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager(UtilisateurDAOJdbcImpl.getInstance());
		}
		return instance;
	}

	public Utilisateur login(String email, String password) {
		return UtilisateurDAOJdbcImpl.login(email, password);
	}
	
	public void create(Utilisateur user) {
		UtilisateurDAOJdbcImpl.create(user);
	}

	/*public void save(Utilisateur utilisateur) {
		utilisateur.setNom(utilisateur.getNom());
		UtilisateurDAOJdbcImpl.save(utilisateur);
	}*/

	public void update(Utilisateur u)  {
		try {
			UtilisateurDAOJdbcImpl.update(u);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Utilisateur findByPseudo(String pseudo) {
		return UtilisateurDAOJdbcImpl.findByPseudo(pseudo);

	}

	public Utilisateur findByEmail(String email) {
		return UtilisateurDAOJdbcImpl.findByEmail(email);
	}

	public void deleteByPseudo(String pseudo) {
			UtilisateurDAOJdbcImpl.deleteByPseudo(pseudo);

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
