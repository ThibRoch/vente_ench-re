package fr.eni.encheres_commun.bll;

import java.util.List;

import fr.eni.encheres_commun.bo.Categorie;
import fr.eni.encheres_commun.dal.CategorieDAO;

public class CategorieManager {
	
	private static CategorieManager instance = null;
	
	public CategorieManager(CategorieDAO catDAO) {
	}

	// SINGLETON
	public static CategorieManager getInstance() {
		if (instance == null) 
			instance = new CategorieManager(CategorieDAO.getInstance());
		
		return instance;
	}
	
	//Méthodes métiers
	public void create(Categorie cat) {
		CategorieDAO.create(cat);
	}
	
	public Categorie read(int noCat) {
		return CategorieDAO.read(noCat);
	}
	
	public void update(Categorie cat){
		CategorieDAO.update(cat);
	}
	
	public void delete(int noCat) {
		CategorieDAO.delete(noCat);
	}
	
	 public List<Categorie> getAll(){
		 return CategorieDAO.getAll();
	 }
	 
	 //TODO Vérification des paramètres
}
