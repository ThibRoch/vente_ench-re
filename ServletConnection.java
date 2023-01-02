package fr.eni.SERVLET;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.BLL.UtilisateurManager;
import fr.eni.BO.Utilisateur;

/**
 * Servlet implementation class Connection
 */
@WebServlet("/ServletConnection")
public class ServletConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/seConnecter.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email,motDePasse;
		Utilisateur user;
		email=request.getParameter("email");
		motDePasse=request.getParameter("motDePasse");
		user=UtilisateurManager.getInstance().login(email, motDePasse);
		
		if(user!= null) {
			request.getSession().setAttribute("userConnected", user);
			response.sendRedirect("lister");
			
		}else {
			response.sendRedirect("seConnecter");
		}
	}

}
