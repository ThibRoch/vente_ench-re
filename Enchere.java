package fr.eni.eni_encheres.bo;

import java.util.Date;

public class Enchere {

	private Date dateEnchere;
	private String nomArticle;
	private int montantEnchere;
	private Utilisateur utilisateur;

	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Enchere() {
	}

	public Enchere(Date dateEnchere, int montantEnchere, Utilisateur utilisateur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchère=" + dateEnchere +", nomArticle = "+ nomArticle+", utilisateur = "+ utilisateur +", montantEnchère=" + montantEnchere + "]";
	}
}
