<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ page import ="fr.eni.eni_encheres.bo.ArticleVendu" %>
    <!DOCTYPE html>
    <html lang="fr">
      <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Les objets sont nos amis</title>
        <link rel="stylesheet" href="style.css" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
      <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto+Condensed:ital,wght@0,300;0,400;0,700;1,300;1,400;1,700&display=swap" rel="stylesheet">
      </head>
      
<body>
	<header>
		<img src="https://zupimages.net/up/22/51/hf35.jpg" />
		<nav>
			<h1>Les objets sont nos amis !</h1>
			<ul>
				<li><a href="${pageContext.request.contextPath}/ServletCreer"
					id="modification">Modifier son compte </a></li>
				<li><a href="${pageContext.request.contextPath}/ServletDeconnection"
					id="déconnexion">Se déconnecter</a></li>
			</ul>
		</nav>
	</header>

  <section>
    <article>
      <form method = post action ="ServletModifier">
        <div class="contain">
          <h2>Vous avez remporté l'enchère</h2>

          <div class="enchere">
            <img src="" />
            <div>${ArticleVendu.nomArticle}</div>
            <b>Description</b>
            <p><input type="text"
              name="description" id="description" value="" maxlength="500"></p></div>

          <div class="user-info">
<div>Meilleure offre : <span>${ArticleVendu.prixVente}</span></div>
<div>Mise à prix : <span>${ArticleVendu.miseAPrix}</span></div>
<div>Retrait : <span>${Retrait.ville} ${Retrait.codePostal}</span></div>
<div>Vendeur : <span>${Utilisateur.pseudo}</span></div>
<div>Téléphone : <span>${Utilisateur.telephone}</span></div>
          </div>

          <button type="submit" class="retour">Retour</button>
        </div>

        </div>
      </form>
  </section>
  </article>

</body>

</html>
