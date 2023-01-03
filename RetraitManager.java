package fr.eni.eni_encheres.bll;

import fr.eni.eni_encheres.bo.*;
import fr.eni.eni_encheres.dal.RetraitDAO;

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
