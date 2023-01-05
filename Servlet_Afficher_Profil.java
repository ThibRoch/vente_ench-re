package fr.eni.SERVLET;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.BO.Utilisateur;

/**
 * Servlet implementation class Servlet_Afficher_Profil
 */
@WebServlet("/Servlet_Afficher_Profil")
public class Servlet_Afficher_Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
   /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("Afficher_profil.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String pseudo,nom,prenom,email,telephone,rue,codePostale,ville,password;
		//Utilisateur u;
		//noUtilisateur = request.getParameter("noUtilisateur");
		pseudo=request.getParameter("pseudo");
		nom=request.getParameter("nom");
		prenom=request.getParameter("prenom");
		email=request.getParameter("email");
		telephone=request.getParameter("telephone");
		rue=request.getParameter("rue");
		codePostale=request.getParameter("code_postale");
		ville=request.getParameter("ville");
		password=request.getParameter("password");
		
	}

}
