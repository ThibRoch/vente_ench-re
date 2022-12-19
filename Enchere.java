package fr.eni.BO;

import java.util.Date;

public class Enchere {

	private Date dateEnchère;
	private String nomArticle;
	private int montantEnchère;
	private Utilisateur utilisateur;

	public Date getDateEnchère() {
		return dateEnchère;
	}

	public void setDateEnchère(Date dateEnchère) {
		this.dateEnchère = dateEnchère;
	}

	public int getMontantEnchère() {
		return montantEnchère;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public void setMontantEnchère(int montantEnchère) {
		this.montantEnchère = montantEnchère;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Enchere() {
	}

	public Enchere(Date dateEnchère, int montantEnchère, Utilisateur utilisateur) {
		super();
		this.dateEnchère = dateEnchère;
		this.montantEnchère = montantEnchère;
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchère=" + dateEnchère +", nomArticle = "+ nomArticle+", utilisateur = "+ utilisateur +", montantEnchère=" + montantEnchère + "]";
	}
}
