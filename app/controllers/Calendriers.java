package controllers;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import play.data.validation.Required;
import play.mvc.Controller;
import play.mvc.With;


public class Calendriers extends Controller {
	
	public static void calendrier() {
		Calendar calendrier = new GregorianCalendar(2016, 9, 31);
		calendrier.set(calendrier.DATE, calendrier.getActualMinimum(calendrier.DATE));
		Locale locale = new Locale("Fr");
		
		render(calendrier, locale);
	}
}
