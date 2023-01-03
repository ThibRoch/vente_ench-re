package fr.eni.encheres_commun.bll;

import fr.eni.encheres_commun.bo.*;
import fr.eni.encheres_commun.dal.RetraitDAO;

public class RetraitManager {
	
	private static RetraitManager instance = null;
	

	public RetraitManager(RetraitDAO retDao) {
	}

	//SINGLETON
	public static RetraitManager getInstance() {
		if (instance == null) 
			instance = new RetraitManager(RetraitDAO.getInstance());
		
		return instance;
	}
	
	//Méthodes Métiers
	public Retrait getRetraitByArticle(ArticleVendu art) {
		return RetraitDAO.getRetraitByArticle(art);
	}
}
