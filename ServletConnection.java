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

		RequestDispatcher rd = request.getRequestDispatcher("Identification.jsp");
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
			response.sendRedirect("Page_Accueil.jsp");
			
		}else {
			response.sendRedirect("Identification");
		}
	}
	
	/*String cPseudo = request.getParameter("pseudo");
	String cPassword = request.getParameter("password");

	String laConnexion = "SELECT * from UTILISATEURS where pseudo ='"+cPseudo +"'"+ " and password='"+cPassword+"'";

	try{
		seConnecter(); //On suppose que cette méthode permet de se connecter à la base
		Statement stat_req = (Statement) connecter.createStatement();
		ResultSet rs1 = stat_req.executeQuery(laConnexion);

		if (rs1.next()){
			System.out.println("Vous êtes connectés");
		}

	}catch(Exception ex)
	{
		System.out.println("Erreur "+ex);
	}

}*/

}
