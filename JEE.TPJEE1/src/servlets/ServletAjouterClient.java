package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Client;
import service.ClientService;
import service.IClientService;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/ServletAjouterClient") // URL d'acc�s � cette Servlet (apr�s URL tomcat)
public class ServletAjouterClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjouterClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// pour encoder la requ�te en utf-8
		request.setCharacterEncoding("utf-8");
		
		// le parametre request contient tout ce qu'on recoit du client
		// (=tableau plein
		// d'infos sur le client : URL, adresse IP, ...)

		// le parametre response n'est plus utilis� depuis qu'il y a des JSP
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// pour encoder la requ�te en utf-8
		request.setCharacterEncoding("utf-8");

		// TODO Auto-generated method stub
		// doGet(request, response);

		// 1 - r�cup�rer param�tres (du formulaire)
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String couleuryeux = request.getParameter("couleurYeux");
				int age = Integer.parseInt(request.getParameter("age"));
			
				
				// 2 - TTT avec couches services
				IClientService ic = new ClientService();
				Client c = new Client(nom,prenom,couleuryeux,age);
				ic.ajouterClient(c);
				
				
				// 3 - pr�paration envoi
				request.setAttribute("lenom", nom); //1er param = nom attribut dans jsp, 2nd param = variable du getParameter
				request.setAttribute("leprenom", prenom);
				request.setAttribute("lacouleuryeux", couleuryeux);
				request.setAttribute("lage", age);

				// 4 - envoi
				request.getRequestDispatcher("/resultatAjouterClient.jsp").forward(request, response);;
		
		
	}

}
