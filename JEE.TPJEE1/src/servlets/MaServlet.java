package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/MaServlet") // URL d'accès à cette Servlet (après URL tomcat)
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// pour encoder la requête en utf-8
		request.setCharacterEncoding("utf-8");
		
		// le parametre request contient tout ce qu'on recoit du client
		// (=tableau plein
		// d'infos sur le client : URL, adresse IP, ...)

		// le parametre response n'est plus utilisé depuis qu'il y a des JSP
		// TODO Auto-generated method stub

		// ancienne façon de faire avec response
		/*
		 * response.getWriter().append("Served at: ").append(request.
		 * getContextPath()).append("\n client adress : ")
		 * .append(request.getRemoteAddr()).append("\n nom : ").append(request.
		 * getParameter("nom"))
		 * .append("\n prenom : ").append(request.getParameter("prenom")).
		 * append("\n pwd : ") .append(request.getParameter("pwd"));
		 */

		// 1 - récupérer paramètres (du formulaire)
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mdp = request.getParameter("pwd");
		String[] lesloisirs = request.getParameterValues("loisirs");
		
		// 2 - TTT avec couches services
		
		// 3 - préparation envoi
		request.setAttribute("lenom", nom); //1er param = nom attribut dans jsp, 2nd param = variable du getParameter
		request.setAttribute("leprenom", prenom);
		request.setAttribute("lemdp", mdp);
		request.setAttribute("lesloisirs", lesloisirs);

		// 4 - envoi
		request.getRequestDispatcher("/resultat.jsp").forward(request, response);;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// pour encoder la requête en utf-8
		request.setCharacterEncoding("utf-8");

		// TODO Auto-generated method stub
		// doGet(request, response);

		response.getWriter().append("Served at: ").append(request.getContextPath()).append("\n client adress : ")
				.append(request.getRemoteAddr()).append("\n nom : ").append(request.getParameter("nom"))
				.append("\n prenom : ").append(request.getParameter("prenom")).append("\n pwd : ")
				.append(request.getParameter("pwd")).append("\n loisirs : ");

		// loisirs correspond au name du formulaire.html
		String[] lesloisirs = request.getParameterValues("loisirs"); 

		for (String l : lesloisirs) {
			response.getWriter().append("\n - " + l);
		}
	}

}
