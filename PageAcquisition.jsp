<!DOCTYPE html>
<html>

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta charset="UTF-8">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&family=Roboto+Condensed:ital,wght@0,300;0,400;0,700;1,300;1,400;1,700&display=swap" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="">
<body>
  <header>
    <h3>Les objets sont nos amis</h3>
    <img src="https://zupimages.net/up/22/51/hf35.jpg" />

    <div id="navbar">
      <a class="active" href="javascript:void(0)">Accueil</a>
      <a href="javascript:void(0)">S'inscrire</a>
      <a href="javascript:void(0)">Se connecter</a>
    </div>
  </header>

  <section>
    <article>
      <form method = post action ="ServletCreer">
        <div class="contain">
          <h1>Vous avez remporté l'enchère</h1>

          <div class="enchere">
            <img src="" />
            <div><%= nom_article %></div>
            <b>Description</b>
            <p><%= description %></div>

          <div class="user-info">
<div>Meilleure offre : <span><%= prix_vente %></span></div>
<div>Mise à prix : <span><%= prix_initial %></span></div>
<div>Retrait : <span><%= no_article %></span></div>
<div>Vendeur : <span><%= pseudo %></span></div>
<div>Téléphone : <span><%= telephone %></span></div>
          </div>

          <button type="submit" class="retour">Retour</button>
        </div>

        </div>
      </form>
  </section>
  </article>

</body>

</html>
