package fr.eni.BO;

public class Retrait {

	private String rue;
	private int codePostale;
	private String ville;
	private ArticleVendu articleVendu;

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
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

	public Retrait(String rue, int codePostale, String ville, ArticleVendu articleVendu) {
		super();
		this.rue = rue;
		this.codePostale = codePostale;
		this.ville = ville;
		this.articleVendu = articleVendu;
	}

	@Override
	public String toString() {
		return "Retrait [articleVendu = "+articleVendu+", rue=" + rue + ", codePostale=" + codePostale + ", ville=" + ville + "]";
	}

}
