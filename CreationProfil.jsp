<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Les objets sont nos amis</title>
</head>
<body>

	<header>
		<img src="https://zupimages.net/up/22/51/hf35.jpg" />
		<nav>
			<div>Les objets sont nos amis !</div>

			<ul>
				<li><a href="<%=response.encodeURL(request.getContextPath()+"/ServletCreer") %>" id="inscription">S'inscrire</a></li>
				<li><a href="<%=response.encodeURL(request.getContextPath()+"/ServletConnection") %>" id="connexion">Se connecter</a></li>
			</ul>
		</nav>
	</header>

	  <form>
		<div class="contain">
			<h1>Créer un compte</h1>
			<h2>Merci de remplir tous les champs pour finaliser la création
				de votre compte.</h2>
			<hr>

			<label for="pseudo"><b>Pseudo</b></label> <input type="text"
				placeholder="Entrer votre pseudo" name="pseudo" id="pseudo" value = "${Utilisateur.pseudo}" required>

			<label for="nom"><b>Nom</b></label> <input type="text"
				placeholder="Entrez votre nom" name="nom" id="nom" value = "${Utilisateur.nom}"required>

			<label for="prenom"><b>Prénom</b></label> <input type="text"
				placeholder="Entrez votre prénom" name="prenom" id="prenom" value = "${Utilisateur.prenom}" required>

			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Entrez votre email" name="email" id="email" value = "${Utilisateur.email}" required>

			<label for="telephone"><b>Téléphone</b></label> <input type="text"
				placeholder="Entrez votre numéro de téléphone" name="telephone"
				id="telephone" value = "${Utilisateur.telephone}"required> 
				
			<label for="rue"><b>Rue</b></label><input type="text" placeholder="Entrez votre rue" name="rue" id="rue" value = "${Utilisateur.rue}"
				required> 
			<label for="codepost"><b>Code Postal</b></label> <input type="text" placeholder="Entrez votre code postal" name="codepost"
				id="codepost"  value = "${Utilisateur.codePostal}" required> 
				
			<label for="ville"><b>Ville</b></label>
				<input type="text" placeholder="Entrez votre ville" name="ville"
				id="ville" value = "${Utilisateur.ville}" required> 
			<label for="mdp"><b>Mot de passe</b></label> <input type="password"
				placeholder="Entrez votre mod de passe" name="mdp" id="mdp" value = "${Utilisateur.password}" required>

			<label for="mdp-repeat"><b>Confirmation de votre mot de passe</b></label> <input type="password"
				placeholder="Confirmez votre mot de passe" name="mdp-repeat"
				id="mdp-repeat" value = "${Utilisateur.password}" required>
			<hr>
			<p>
				En créant votre compte vous acceptez les <a href="#">termes de
					confidentialité</a>.
			</p>

			<button type="submit" class="enregistrer"
				onclick=<%="request.getContextPath()/ServletConnection"%>>S'enregistrer</button>
		</div>

		<div class="identifier">
			<p>
				Vous avez déjà un compte ? <a href="#" onclick=<%="request.getContextPath()/ServletIdentification"%>>Indentifiez-vous</a>.
			</p>
		</div>
	</form>

</body>
</html>