<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="fr.eni.BO.Utilisateur" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="">
<title>Les objets sont nos amis</title>
</head>
<body>

	<header>
		<img src="https://zupimages.net/up/22/51/hf35.jpg" />
		<nav>
			<form method="post">
				<div>Les objets sont nos amis !</div>

				<ul>
					<li><a
						href="<%=response.encodeURL(request.getContextPath() + "/ServletCreer")%>"
						id="inscription">S'inscrire</a></li>
					<li><a
						href="<%=response.encodeURL(request.getContextPath() + "/ServletConnection")%>"
						id="connexion">Se connecter</a></li>
				</ul>
			</form>
		</nav>
	</header>

	<h1>Affichage de votre compte</h1>
	
	<form>
			<label for="pseudo"><b>Pseudo</b></label> <input type="text"
				 name="pseudo" id="pseudo" value = "${Utilisateur.pseudo }" required>

			<label for="nom"><b>Nom</b></label> <input type="text"
				 name="nom" id="nom" value = "${Utilisateur.nom}"required>

			<label for="prenom"><b>Prénom</b></label> <input type="text"
				 name="prenom" id="prenom" value = "${Utilisateur.prenom}" required>

			<label for="email"><b>Email</b></label> <input type="text"
				name="email" id="email" value = "${Utilisateur.email}" required>

			<label for="telephone"><b>Téléphone</b></label> <input type="text"
				 name="telephone"
				id="telephone" value = "${Utilisateur.telephone}"required> 
				
			<label for="rue"><b>Rue</b></label><input type="text"  name="rue" id="rue" value = "${Utilisateur.rue}"
				required> 
				
			<label for="codepost"><b>Code Postal</b></label> <input type="text"  name="codepost"
				id="codepost"  value = "${Utilisateur.codePostal}" required> 
				
			<label for="ville"><b>Ville</b></label>
				<input type="text"  name="ville"
				id="ville" value = "${Utilisateur.ville}" required> 
				
			<label for="mdp"><b>Mot de passe</b></label> <input type="password"
				 name="mdp" id="mdp" value = "${Utilisateur.password}" required>
				 
				 
				 
				 <input type='submit' value="Enregistrer">
				 <input type ='reset' value ="Supprimer le compte">
				 <button type='button' class="retour" onclick ="">Retour</button>
		</form>	
	</body>
</html>