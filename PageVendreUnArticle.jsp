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

<body>

	<header>
		<img src="https://zupimages.net/up/22/51/hf35.jpg" />
    <h1>Les objets sont nos amis !</h1>
		<nav>
				<ul>
					<li><a href="${pageContext.request.contextPath}/ServletCreer"
					id="modification">Modifier son compte </a></li>
				<li><a href="${pageContext.request.contextPath}/ServletDeconnection"
					id="déconnexion">Se déconnecter</a></li>
			</ul>
		</nav>
	</header>

	<div class="contain" style="width:80%; margin:10px auto";>
	<h2>Nouvelle vente</h2>

	<form method="post" action="Servlet">

		<fieldset>

			<img src=""> 
			<label for="article"><b> Article : </b></label><input
				type="text" name="article" id="article" value=""> 
			<label for="description"><b> Description : : </b></label><input type="text"
				name="description" id="description" value="" maxlength="500">
			<label for="categorie"> Catégorie :</label> <select name="categorie" style="margin-bottom:15px;">
				<optgroup>
					<option>Toutes</option>
					<option>Informatique</option>
					<option>Ameublement</option>
					<option>Vêtement</option>
					<option>Sport/Loisir</option>
				</optgroup>
			</select> 
			<label for="upload"><b>Photo de l'article</b></label><input
				type="file" name="upload" onclick="" accept="image/png, image/jpeg">
			<label for="prix"> <b>Mise a prix</b></label><input type="number"
				name="prix" min="10" max="2000"> 
			<label for="dèbut_enchère"><b>Début de l'enchère :</b></label><input type="date" value="" name="firstdate">
			<label for="fin_enchère"><b> Fin de l'enchère :</b></label><input
				type="date" name="lastdate" min="" max="">

		</fieldset>

		<fieldset>
			<h3> Retrait : </h3>
			<hr>
			<label for="rue"><b> Rue : </b></label><input type="text" name="rue"
				id="rue" value="${Utilisateur.rue}"> 
			<label for="codpost"><b>Code Postal : </b></label><input type="text" name="codepost" id="codepost" value="${Utilisateur.codepost}">
			<label for="ville"><b> Ville : </b></label><input type="text"
				name="ville" id="ville" value="${Utilisateur.ville}">
		</fieldset>

		<button type="submit" onclick="">Enregistrer</button>
		<button type="reset" onclick="">Annuler</button>
		<button type="reset" onclick="">Annuler la vente</button>

	</form>
	</div>

</body>
</html>
