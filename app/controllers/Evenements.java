package controllers;

import java.util.*;

import play.mvc.Controller;
import play.mvc.With;
import services.EvenementService;
import play.data.validation.*;


public class Evenements extends Controller {
	
	public static void ajout_evenement(int id_date){
		EvenementService.ajout_evenement(id_date);
	}
	
	public static void save_evenement(@Required Long id_date, @Required String nom, String description ){
		EvenementService.save_evenement(id_date, nom, description );
	}
}
