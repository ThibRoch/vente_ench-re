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
	  <form method = post action ="ServletCreer">
		<div class="contain">
			<h2>Créer un compte</h2>
			<h3>Merci de remplir tous les champs pour finaliser la création
				de votre compte.</h3>
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
				placeholder="Entrez votre mod de passe" name="password" id="password" <%!String mdp; %> required>

			<label for="password-repeat"><b>Confirmation de votre mot de passe</b></label> <input type="password"
				placeholder="Confirmez votre mot de passe" name="mdp-repeat"
				id="password-repeat" <%! String valMdp; %>required>
			<hr>
			
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
	</article>
</section>
</body>
</html>
