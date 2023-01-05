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
			<form method="post">
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

	<form action="ServletConnection" method="post">

		<h2>Me connecter à mon compte</h2>

		<div class="contain">
			<label for="username"><b>Pseudo ou email :</b></label> <input
				type="text" placeholder="Entrer votre pseudo" name="uname"
				value="" required>

			<label for="mdp"><b>Mot de passe :</b></label> <input type="password"
				placeholder="Entrer votre mot de passe" name="psw"
				value="" required>

			<button type="submit">Connexion</button>
			<label> <input type="checkbox" checked="checked"
				name="remember"> Se souvenir de moi
			</label> <span class="mdp">Mot de passe <a href="#">oublié ?</a></span>
		</div>
	</form>
	
	<form action="ServletCreer">
		<button type="submit">Créer un compte</button>
	</form>
</body>
</html>
