<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="page_d'inscription_css.css">
<title>Les objets sont nos amis</title>
</head>
<body>

	<header>
		<img src="https://zupimages.net/up/22/51/hf35.jpg" />
		<nav>
			<div>Les objets sont nos amis !</div>

			<ul>
				<li><a href="${pageContext.request.contextPath}/ServletCreer" id="inscription">S'inscrire</a></li>
				<li><a href="${pageContext.request.contextPath}/ServletConnection" id="connexion">Se connecter</a></li>
			</ul>
		</nav>
	</header>

	  <form method = post action ="ServletCreer">
		<div class="contain">
			<h1>Créer un compte</h1>
			<h2>Merci de remplir tous les champs pour finaliser la création
				de votre compte.</h2>
			<hr>

			<label for="pseudo"><b>Pseudo</b></label> <input type="text"
				placeholder="Entrer votre pseudo" name="pseudo" id="pseudo" value = "" required>

			<label for="nom"><b>Nom</b></label> <input type="text"
				placeholder="Entrez votre nom" name="nom" id="nom" value = ""required>

			<label for="prenom"><b>Prénom</b></label> <input type="text"
				placeholder="Entrez votre prénom" name="prenom" id="prenom" value = "" required>

			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Entrez votre email" name="email" id="email" value = "" required>

			<label for="telephone"><b>Téléphone</b></label> <input type="text"
				placeholder="Entrez votre numéro de téléphone" name="telephone"
				id="telephone" value = ""required> 
				
			<label for="rue"><b>Rue</b></label><input type="text" placeholder="Entrez votre rue" name="rue" id="rue" value = ""
				required> 
				
			<label for="codepost"><b>Code Postal</b></label> <input type="text" placeholder="Entrez votre code postal" name="codepost"
				id="codepost"  value = "" required> 
				
			<label for="ville"><b>Ville</b></label>
				<input type="text" placeholder="Entrez votre ville" name="ville"
				id="ville" value = "" required> 
				
			<label for="password"><b>Mot de passe</b></label> <input type="password"
				placeholder="Entrez votre mod de passe" name="mdp" id="password" <%!String mdp; %> required>

			<label for="password-repeat"><b>Confirmation de votre mot de passe</b></label> <input type="password"
				placeholder="Confirmez votre mot de passe" name="mdp-repeat"
				id="password-repeat" <%! String valMdp; %>required>
			<hr>
			<% if(mdp.equals(valMdp)) {
				
			}else {
				out.println("Erreur, veuillez saisir le même mot de passe");
			};
			
			%>
			<p>
				En créant votre compte vous acceptez les <a href="#">termes de
					confidentialité</a>.
			</p>

			<button type="submit" class="enregistrer">S'enregistrer</button>
		</div>
		</form>
		
		<form method="post" action ="ServletConnection">
		<div class="identifier">
			<p>
				Vous avez déjà un compte ? <a href="#" onclick="">Indentifiez-vous</a>.
			</p>
		</div>
		</form>
	
</body>
</html>