package fr.eni.SERVLET;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.DAL.UtilisateurDAO;


/**
 * Servlet implementation class Supprimer
 */
@WebServlet("/ServletSupprimer")
public class ServletSupprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo;
		pseudo = request.getParameter("pseudo");
		UtilisateurDAO.deleteByPseudo(pseudo);
		response.sendRedirect("Creer");

	}
}
