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
 * Servlet implementation class GestionClients
 */
@WebServlet("/GestionClients")
public class GestionClients extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionClients() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("action").equals("ajouter")) {
			// 1 - récupérer paramètres (du formulaire)
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String couleuryeux = request.getParameter("couleurYeux");
			int age = Integer.parseInt(request.getParameter("age"));

			// 2 - TTT avec couches services
			IClientService ic = new ClientService();
			Client c = new Client(nom, prenom, couleuryeux, age);
			ic.ajouterClient(c);

			// 3 - préparation envoi
			request.setAttribute("lenom", nom); // 1er param = nom attribut dans
												// jsp, 2nd param = variable du
												// getParameter
			request.setAttribute("leprenom", prenom);
			request.setAttribute("lacouleuryeux", couleuryeux);
			request.setAttribute("lage", age);

			// 4 - envoi
			request.getRequestDispatcher("/resultatAjouterClient.jsp").forward(request, response);
			;
		}

		if (request.getParameter("action").equals("lister")) {
		}
		if (request.getParameter("action").equals("supprimer")) {
		}
		if (request.getParameter("action").equals("modifier")) {
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
