<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="liste_des_encheres.css">

<title>Les objets sont nos amis</title>
</head>
<body>
	<header>
		<a>ENI-Encheres</a> 
		<a href="${pageContext.request.contextPath}/ServletCreer" id="inscription"> S'inscrire</a> 
		<a href="${pageContext.request.contextPath}/ServletConnection" id="connection"> Se connecter</a>
	</header>

	<h1>Liste des enchères</h1>

	<section>
		<strong> Filtres : </strong><input type="search" id="site-search"
			name="artc-search" placeholder="nom de l'article">

		<!-- <button>Search</button> -->

		<label for="categorie"> Catégorie :</label> <select name="categorie">
			<optgroup>
				<option>Toutes</option>
				<option>Informatique</option>
				<option>Ameublement</option>
				<option>Vêtement</option>
				<option>Sport/Loisir</option>
			</optgroup>
		</select>

		<button type="submit" name="rechercher" onclick="">Rechercher</button>

		<fieldset id="global">
			<div id="achat">
				<input type="radio" name="selec" value="achat" checked> <label
					for="achat">Achats</label>
				<div>
					<input type="checkbox" id="ouverte" name="open" checked> <label
						for="ouverte">enchères ouvertes</label>
				</div>
				<div>
					<input type="checkbox" id="encours" name="attente"> <label
						for="encours">mes enchères en cours</label>
				</div>
				<div>
					<input type="checkbox" id="gagner" name="win"> <label
						for="gagner">mes enchères remportées</label>
				</div>

			</div>

			<div id="vente">
				<input type="radio" name="selec" value="ventes"> <label
					for="ventes">Mes ventes</label>
				<div>
					<input type="checkbox" id="attente" name="load"> <label
						for="attente">mes ventes en cours</label>
				</div>
				<div>
					<input type="checkbox" id="enattente" name="nondebute"> <label
						for="enattente">ventes non débutés</label>
				</div>
				<div>
					<input type="checkbox" id="fini" name="fin"> <label
						for="fini">ventes remportées</label>
				</div>

			</div>
		</fieldset>
	</section>
	<hr>

	<fieldset>

		<img src="">
		<p>
			<u> </u>
		</p>
		<p>Prix :</p>
		<p>Fin de l'enchère :</p>
		<p>Vendeur</p>


	</fieldset>

</body>
</html>