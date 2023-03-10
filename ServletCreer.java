package fr.eni.SERVLET;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.BO.Utilisateur;
import fr.eni.DAL.UtilisateurDAO;


/**
 * Servlet implementation class Creer
 */
@WebServlet("/ServletCreer")
public class ServletCreer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/CreationProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noUtilisateur = 0;
		String pseudo,nom,prenom,email,telephone,rue,codePostale,ville,password;
		Utilisateur u;
		//noUtilisateur = request.getParameter("noUtilisateur").toString();
		pseudo=request.getParameter("pseudo");
		nom=request.getParameter("nom");
		prenom=request.getParameter("prenom");
		email=request.getParameter("email");
		telephone=request.getParameter("telephone");
		rue=request.getParameter("rue");
		codePostale=request.getParameter("codepost");
		ville=request.getParameter("ville");
		password=request.getParameter("password");
		
		/*if(request.getParameter("password").equals(request.getParameter("mdp-repeat"))) {
			System.out.println("Mot de passe validée");
			response.sendRedirect("Afficher_profil");
		}else {
			response.sendError(401, "Mot de passe différent");
			response.sendRedirect("CreationProfil");
		};*/
		
		
		u=new Utilisateur(noUtilisateur, pseudo,nom,prenom,email,telephone,rue,codePostale,ville,password, false);
		UtilisateurDAO.create(u);
		
		noUtilisateur++;
		
		// Renvoi vers une autre servlet pour afficher les infos
		RequestDispatcher dispat = request.getRequestDispatcher("Servlet_Afficher_Profil.jsp");
		dispat.forward(request,response);
		
	}

}
