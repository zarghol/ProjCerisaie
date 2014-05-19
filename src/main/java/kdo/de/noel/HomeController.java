package kdo.de.noel;

import java.util.List;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kdo.de.meserreurs.MonException;
import kdo.de.utilitaires.JBossContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	

	@RequestMapping(value = "index.htm")
	public ModelAndView afficheindex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("Accueil");
	}

	@RequestMapping(value = "Clients.htm")
	public ModelAndView clients(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage = "";
		List<Client> mesClients = null;

		// On appelle notre EJB
		Context ctxt = JBossContext.getInitialContext();
		GestionClient unclientRemote = (GestionClient) ctxt.lookup("BeanCerisaie");
		try {
			mesClients = unclientRemote.listerTousLesClients();
			destinationPage = "Clients";
		} catch (MonException e) {
			destinationPage = "Erreur";
			request.setAttribute("MesErreurs", e.getCause() + " : " + e.getMessage());
		}
		return new ModelAndView(destinationPage, "mesClients", mesClients);
	}

	@RequestMapping(value = "Sejour.htm")
	public ModelAndView sejours(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage = "";
		List<Sejour> mesSejour = null;

		// On appelle notre EJB
		Context ctxt = JBossContext.getInitialContext();
		GestionClient unclientRemote = (GestionClient) ctxt.lookup("BeanCerisaie");
		try {
			mesSejour = unclientRemote.listerTousLesClients();
			destinationPage = "Sejours";
		} catch (MonException e) {
			destinationPage = "Erreur";
			request.setAttribute("MesErreurs", e.getCause() + " : " + e.getMessage());
		}
		return new ModelAndView(destinationPage, "mesSejour", mesSejour);
	}
	
	@RequestMapping(value = "ActivitesSportives.htm")
	public ModelAndView activitesSportives(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String destinationPage = "";
		List<ActiSport> mesActiSport = null;

		// On appelle notre EJB
		Context ctxt = JBossContext.getInitialContext();
		GestionClient unclientRemote = (GestionClient) ctxt.lookup("BeanCerisaie");
		try {
			mesActiSport = unclientRemote.listerTousLesClients();
			destinationPage = "ActivitesSportive";
		} catch (MonException e) {
			destinationPage = "Erreur";
			request.setAttribute("MesErreurs", e.getCause() + " : " + e.getMessage());
		}
		return new ModelAndView(destinationPage, "mesActiSport", mesActiSport);
	}
	
}
