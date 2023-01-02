package fr.eni.eni_encheres.bo;

import java.util.Date;
import java.util.List;

public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private Date dateDebutEnchere;
	private Date dateFinEnchere;
	private int miseAPrix;
	private int prixVente;
	private Utilisateur vendeur;
	private Categorie categorie;
	private Retrait pointRelai;
	private List<Enchere> nouvellesEncheres;

	/**
	 * @param noArticle
	 * @param nomArticle
	 * @param description
	 * @param dateDebutEnchere
	 * @param dateFinEnchere
	 * @param prixInitial
	 * @param prixVente
	 * @param noUtilisateur
	 * @param categorieArticle
	 */
	public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEnchere,
			Date dateFinEnchere, int prixInitial, int prixVente, Utilisateur vendeur, Categorie categorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.miseAPrix = prixInitial;
		this.prixVente = prixVente;
		this.vendeur = vendeur;
		this.categorie = categorie;
	}

	/**
	 * 
	 */
	public ArticleVendu() {
	}

	/**
	 * @return the noArticle
	 */
	public int getNoArticle() {
		return noArticle;
	}

	/**
	 * @param noArticle the noArticle to set
	 */
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	/**
	 * @return the nomArticle
	 */
	public String getNomArticle() {
		return nomArticle;
	}

	/**
	 * @param nomArticle the nomArticle to set
	 */
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the dateDebutEnchere
	 */
	public Date getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	/**
	 * @param dateDebutEnchere the dateDebutEnchere to set
	 */
	public void setDateDebutEnchere(Date dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	/**
	 * @return the dateFinEnchere
	 */
	public Date getDateFinEnchere() {
		return dateFinEnchere;
	}

	/**
	 * @param dateFinEnchere the dateFinEnchere to set
	 */
	public void setDateFinEnchere(Date dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	/**
	 * @return the prixIntial
	 */
	public int getMiseAPrix() {
		return miseAPrix;
	}

	/**
	 * @param prixInitial the prixInitial to set
	 */
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	/**
	 * @return the prixVente
	 */
	public int getPrixVente() {
		return prixVente;
	}

	/**
	 * @param prixVente the prixVente to set
	 */
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	/**
	 * @return the noVendeur
	 */
	public Utilisateur getVendeur() {
		return vendeur;
	}

	/**
	 * @param noVendeur the noUtilisateur to set
	 */
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	/**
	 * @return the noCategorie
	 */
	public Categorie getNoCategorie() {
		return categorie;
	}

	/**
	 * @param noCategorie the noCategorie to set
	 */
	public void setNoCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	/**
	 * @return the pointRelai
	 */
	public Retrait getPointRelai() {
		return pointRelai;
	}

	/**
	 * @param pointRelai the pointRelai to set
	 */
	public void setPointRelai(Retrait pointRelai) {
		this.pointRelai = pointRelai;
	}

	
	
	/**
	 * @return the nouvellesEncheres
	 */
	public List<Enchere> getNouvellesEncheres() {
		return nouvellesEncheres;
	}

	/**
	 * @param nouvellesEncheres the nouvellesEncheres to set
	 */
	public void setNouvellesEncheres(List<Enchere> nouvellesEncheres) {
		this.nouvellesEncheres = nouvellesEncheres;
	}

	@Override
	public String toString() {
		return "ArticleVendu [no=" + noArticle + ", nom=" + nomArticle + ", description=" + description
				+ ", dateDebutEnchere=" + dateDebutEnchere + ", dateFinEnchere" + dateFinEnchere + ", prixInitial"
				+ miseAPrix + ", prixVente" + prixVente + "Vendeur=" + vendeur + "noCategorie" + categorie
				+ "]";
	}
}
