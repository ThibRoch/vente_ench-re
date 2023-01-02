package fr.eni.eni_encheres.bo;

public class Retrait {

	private String rue;
	//code_postal est un Varchar(15) dans la BDD (String du coup ?)
	private String codePostal;
	private String ville;
	private ArticleVendu articleVendu;

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	public Retrait() {
	}

	public Retrait(String rue, String codePostal, String ville, ArticleVendu articleVendu) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.articleVendu = articleVendu;
	}

	@Override
	public String toString() {
		return "Retrait [articleVendu = "+articleVendu+", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + "]";
	}

}
