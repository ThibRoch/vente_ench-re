package fr.eni.encheres_commun.bll;

import java.util.List;

import fr.eni.encheres_commun.bo.Enchere;
import fr.eni.encheres_commun.dal.EnchereDAO;

public class EnchereManager {

private static EnchereManager instance = null;
	

	public EnchereManager(EnchereDAO enchDao) {
	}

	//SINGLETON
	public static EnchereManager getInstance() {
		if (instance == null) 
			instance = new EnchereManager(EnchereDAO.getInstance());
		
		return instance;
	}
	
	//Méthodes Métiers
	public void addEnchere(Enchere ench) {
		EnchereDAO.addEnchere(ench);
	}
	
	public List<Enchere> getEncheres(){
		return EnchereDAO.getEncheres();
	}
	
	//TODO Vérifications Paramètres
}
