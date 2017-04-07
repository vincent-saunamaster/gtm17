package servlets;

import java.io.IOException;
import java.util.Collection;

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
@WebServlet("/ServletListerClientplusJSTLetEL") // URL d'accès à cette Servlet (après URL
									// tomcat)
public class ServletListerClientplusJSTLetEL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 
	private IClientService ic = new ClientService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletListerClientplusJSTLetEL() {
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

		// 1 - récupérer paramètres (du formulaire)

		// 2 - TTT avec couches services
		Collection<Client> lesclients = ic.listerClient();
		
		// version altenative avec des Arraylist
		//List<Client> lesclients = new ArrayList<Client>();
		//lesclients = (List<Client>) ic.listerClient();

		// 3 - préparation envoi
		request.setAttribute("col", lesclients);

		// 4 - envoi
		request.getRequestDispatcher("/resultatListerClientPlusJSTLetEL.jsp").forward(request, response);
		;

	}

}
