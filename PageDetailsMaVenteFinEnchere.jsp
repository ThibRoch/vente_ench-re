<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
    <h1>Les objets sont nos amis !</h1>
		<nav>
				<ul>
					<li><a
						href="<%=response.encodeURL(request.getContextPath() + "/ServletCreer")%>"
						id="inscription">S'inscrire</a></li>
					<li><a
						href="<%=response.encodeURL(request.getContextPath() + "/ServletConnection")%>"
						id="connexion">Se connecter</a></li>
				</ul>
		</nav>
	</header>

  <section>
    <article>
      <form method="post">
        <div class="contain">
          <h2>${Utilisateur.pseudo} a remporté l'enchère</h2>

          <div class="enchere">
            <img src="https://via.placeholder.com/350x150" />
            <div>${ArticleVendu.nomArticle}</div>
            <hr>
            <b>Description</b>
            <p><input type="text"
              name="description" id="description" value="" maxlength="500"></p>
          </div>

          <div class="user-info">
            <div><p>Meilleure offre :</p> <span>${ArticleVendu.prixVente}</span></div>
            <div><p>Mise à prix :</p> <span>${ArticleVendu.miseAPrix}</span></div>
            <div><p>Fin de l'enchère :</p> <span>${ArticleVendu.dateFinEnchere}</span></div>
            <div><p>Retrait :</p> <span>${Retrait.ville} ${Retrait.codePostal}</span></div>
            <div><p>Vendeur :</p> <span>${Utilisateur.pseudo}</span></div>
          </div>

          <button type="submit" class="retrait">Retrait effectué</button>
        </div>

        </div>
      </form>
  </section>
  </article>

</body>

</html>
