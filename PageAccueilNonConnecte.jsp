<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ page import ="fr.eni.eni_encheres.bo" %>
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

    <form method="post">
    <div class="contain">
	<h2>Liste des enchères</h2>


    <span class="label filtres"> Filtres :</span>
    <hr>
    <input type="search" id="site-search"
			name="artc-search" placeholder="nom de l'article">

    <span class="label categories">Catégorie :</span> 
    <hr>
    <select name="categorie">
			<optgroup>
				<option>Toutes</option>
				<option>Informatique</option>
				<option>Ameublement</option>
				<option>Vêtement</option>
				<option>Sport/Loisir</option>
			</optgroup>
		</select>

		<button type="submit" name="rechercher">Rechercher</button>

        <div class="bloc_enchere">
            <img src="" />
                <div>${ArticleVendu.nomArticle}</div>
    
              <ul>
                <li>${ArticleVendu.prixVente} : </li>
                <li>${ArticleVendu.dateFinEnchere} :</li>
                <li>${ArticleVendu.Utilisateur.vendeur} :</li>
              </ul>
            </div>
    
        </div>
</div>
</form>

</body>
</html>
