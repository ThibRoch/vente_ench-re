package fr.eni.eni_encheres.bll;

import java.util.List;

import fr.eni.eni_encheres.bo.*;
import fr.eni.eni_encheres.dal.ArticleVenduDAO;

public class ArticleVenduManager {
	
	private static ArticleVenduManager instance = null;
	
	public ArticleVenduManager(ArticleVenduDAO artDAO) {
	}

	//Singleton
	public static ArticleVenduManager getInstance() {
		if (instance == null)
			instance = new ArticleVenduManager(ArticleVenduDAO.getInstance());
		
		return instance;
	}
	
	//Méthodes Métiers
	public void saveEnchere(ArticleVendu vendeur) {
		ArticleVenduDAO.saveEnchere(vendeur);
	}
	
	public void deleteByNoArticle(int noArt) {
		ArticleVenduDAO.deleteByNoArticle(noArt);
	}
	
	public List<ArticleVendu> findAll(Utilisateur vendeur) {
		return ArticleVenduDAO.findAll(vendeur);
	}
	
	public ArticleVendu findById(int noArticle) {
		return ArticleVenduDAO.findById(noArticle);
	}
	
	//TODO Vérification des paramètres
}
