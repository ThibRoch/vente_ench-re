package fr.eni.eni_encheres.bo;

import java.util.Date;

public class Enchere {

	private Date dateEnchere;
	private String nomArticle;
	private int montantEnchere;
	private Utilisateur user;

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

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Enchere() {
	}

	public Enchere(Date dateEnchere, int montantEnchere, Utilisateur user) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Enchere [dateEnchère=" + dateEnchere +", nomArticle = "+ nomArticle+", utilisateur = "+ user +", montantEnchère=" + montantEnchere + "]";
	}
}
