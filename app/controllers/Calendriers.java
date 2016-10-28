package controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import play.mvc.Controller;
import play.mvc.With;
import play.data.validation.*;


public class Calendriers extends Controller {
	
	public static void calendrier() {
		Calendar calendrier = new GregorianCalendar(2016, 9, 31);
		Locale locale = new Locale("Fr");
		List<String> days = getDays(calendrier, locale);
		// Date du jour pour déduction du jour actif
		Date now = new Date();

		render(calendrier, locale, days, now);
	}

	public static void ajout_evenement(int id_date){
		render(id_date);
	}
	
	public static void save_evenement(@Required Long id_date, @Required String nom, String description ){
		Calendar calendrier = new GregorianCalendar(2016, 9, 31);
		Locale locale = new Locale("Fr");
		List<String> days = getDays(calendrier, locale);
		// Date du jour pour déduction du jour actif
		Date now = new Date();
		renderTemplate("Calendriers/calendrier.html", id_date, nom, description, calendrier, locale, days, now);
	}
	
	private static List<String> getDays(Calendar calendrier, Locale locale){
		calendrier.set(calendrier.DATE, calendrier.getActualMinimum(calendrier.DATE));
		int month = calendrier.get(Calendar.MONTH) + 1;
		int year = calendrier.get(Calendar.YEAR);
		int dayOfWeek = calendrier.get(Calendar.DAY_OF_WEEK) - 2;

		List<String> days = new ArrayList<String>();
		// Récupération de tous les jours du mois précédent
		for( int i = 0; i < dayOfWeek ; i++){
			days.add("empty");
		}

		// Boucle sur l'ensemble des jours du mois
		int totalDaysOfmonth = calendrier.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 1; i < totalDaysOfmonth + 1; i ++){
			days.add((i < 10 ? "0" + i : i) + "") ; //+ "-" + String.valueOf(month) + "-" + year);
		}

		// Déduction du nombre des jours du mois suivant pour combler les cellules du tableau
		// Si le compte n'est pas exact, ajout des cellules manquantes
		int daysSize = days.size();
		int modulo = daysSize % 7;
		if (modulo != 0){
			int totalRemaingCells = (daysSize - modulo + 7) - daysSize;
			for(int i = 0; i < totalRemaingCells; i++){
				days.add("empty");
			}
		}
		return days;
	}
}
