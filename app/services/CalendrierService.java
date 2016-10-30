package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CalendrierService {
	
	public static List<String> getDays(Calendar calendrier, Locale locale){
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
