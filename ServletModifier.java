package fr.eni.SERVLET;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.BLL.UtilisateurManager;
import fr.eni.BO.Utilisateur;

/**
 * Servlet implementation class Modifier
 */
@WebServlet("/ServletModifier")
public class ServletModifier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo;
		Utilisateur user;
		pseudo = request.getParameter("pseudo");
		user = UtilisateurManager.getInstance().findByPseudo(pseudo);
		request.setAttribute("pseudo", user);
		getServletContext().getRequestDispatcher("/WEB-INF/modifier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo;
		Utilisateur user;
		pseudo = request.getParameter("pseudo");
		user = UtilisateurManager.getInstance().findByPseudo(pseudo);
		user.setNom(request.getParameter("nom"));
		user.setPrenom(request.getParameter("prenom"));
		user.setEmail(request.getParameter("email"));
		user.setMotDePasse(request.getParameter("password"));
		UtilisateurManager.getInstance().update(user);
		response.sendRedirect("lister");
	}

}
