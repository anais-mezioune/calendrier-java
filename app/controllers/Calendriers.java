package controllers;

import java.util.*;

import models.Calendrier;
import play.mvc.Controller;
import play.mvc.With;
import play.data.validation.*;


public class Calendriers extends Controller {
	
	public static void calendrier() {
		Calendrier calendrier = new Calendrier();
		Calendar calendar = calendrier.calendar;
		Locale locale = calendrier.locale;
		List<String> days = calendrier.days;
		Date now = calendrier.now;
		render(calendar, locale, days, now);
	}
}
