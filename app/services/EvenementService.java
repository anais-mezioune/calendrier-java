package services;

import java.util.*;

import models.Calendrier;
import models.Evenement;
import play.mvc.Controller;
import play.mvc.With;
import play.data.validation.*;

public class EvenementService extends Controller {
	
	public static void ajout_evenement(int id_date){
		render(id_date);
	}
	
	public static void save_evenement(@Required Long id_date, @Required String nom, String description ){
		Calendrier calendrier = new Calendrier();
		Evenement evenement = new Evenement(nom, description);
		evenement.save();
		renderTemplate("Calendriers/calendrier.html", id_date, nom, description, calendrier, calendrier.locale, calendrier.days, calendrier.now);
	}
}
