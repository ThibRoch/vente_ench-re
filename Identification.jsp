<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="page_de_connexion_css.css">
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

	<form action="ServletConnection" method="post">

		<h1>Me connecter à mon compte</h1>

		<div class="contain">
			<label for="username"><b>Pseudo ou email :</b></label> <input
				type="text" placeholder="Entrer votre pseudo" name="uname"
				value="${Utilisateur.pseudo || Utilisateur.email}" required>

			<label for="mdp"><b>Mot de passe :</b></label> <input type="password"
				placeholder="Entrer votre mot de passe" name="psw"
				value="${Utilisateur.password}" required>

			<button type="submit">Connexion</button>
			<label> <input type="checkbox" checked="checked"
				name="remember"> Se souvenir de moi
			</label> <span class="mdp">Mot de passe <a href="#">oublié ?</a></span>
		</div>
	</form>

	<form method="post" action="ServletCreer">
		<button type="button" class="inscrire">Créer un compte</button>
	</form>


</body>
</html>