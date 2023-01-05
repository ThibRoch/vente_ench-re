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
	
	<section>
	<article>
	<form>
		<div class="contain">
			<h2>Modifier mon profil</h2>
			<label for="pseudo"><b>Pseudo</b></label> <input type="text"
				 name="pseudo" id="pseudo" value = "${Utilisateur.pseudo}" required>

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
				
			<label for="mdp"><b>Mot de passe actuel</b></label> <input type="password"
				 name="mdp" id="mdp" value = "${Utilisateur.password}" required>

			<label for="password"><b>Nouveau mot de passe</b></label> <input type="password"
				 placeholder="Entrez votre mod de passe" name="password" id="password" <%!String mdp; %> required>
 
			 <label for="password-repeat"><b>Confirmation de votre mot de passe</b></label> <input type="password"
				 placeholder="Confirmez votre mot de passe" name="mdp-repeat"
				 id="password-repeat" <%! String valMdp; %>required>
				 
				 <input type='submit' class="enregistrer" value="Enregistrer">
				 <input type ='reset' class="supprimer" style="margin-bottom:10px;" value ="Supprimer le compte">
				 <button type='button' class="retour" onclick ="">Retour</button>
				</div>
		</form>	
	</article>
	</section>
	</body>
</html>
