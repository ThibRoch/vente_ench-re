package fr.eni.ventes_encheres.dal;

import java.util.List;

import fr.eni.ventes_encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	public Utilisateur login(String email, String motDePasse);
	public void create(Utilisateur user);
	public void deleteByPseudo(String pseudo);
	public void update(Utilisateur user);
	public List<Utilisateur> findAll(String field, String sens);
	public Utilisateur findByPseudo(String pseudo);
	public Utilisateur findByEmail(String email);
}
