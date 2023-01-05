<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ page import ="fr.eni.eni_encheres.bo.Enchere" %>
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
	
	<div class="contain" style="width:80%; margin:10px auto";>
	<h2> Détail vente</h2>
		
		<form method="post" action="Servlet">

		<fieldset>

			<img src=""> 
			<input type="text" name="nomArticle" id="article" value="${ArticleVendu.nomArticle}"> 
			<label for="description"><b> Description : : </b></label><input type="text" name="description" id="description" value="${ArticleVendu.description}" maxlength="500">
			<label for="categorie"><b>Catégorie :</b></label> <input type="text" name="categorie" value="${Categorie.libelle}">
			
			<label for="offre"> Meilleure offre : </label><input type="text" name="offre" value="${Enchere.montantEnchere}">
			<label for="prix"> <b>Mise a prix</b></label><input type="number" name="prix" value="${Article.miseAPrix}"> 
			<label for="fin_enchere"><b> Fin de l'enchère :</b></label><input type="text" name="lastdate" value="${Enchere.dateEnchere}">

			<label for="retrait"><b> Retrait :</b></label><input type="text" name="adresse" value="${Retrait.}">
			<label for="vendeur"><b> Vendeur :</b></label><input type="text" name="vendeur" value="${ArticleVendu.vendeur}">
			<label for="enchere"><b> Ma proposition :</b></label><input type="number" name="enchere" min="${Enchere.montantEnchere}">
			
			<button type="submit" onclick=""> Enchérir</button>
			
		</fieldset>
	
	</form>
	</div>

</body>
</html>
