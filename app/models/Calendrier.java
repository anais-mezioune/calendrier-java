package models;

import services.CalendrierService;

import java.text.SimpleDateFormat;
import java.util.*;

import play.*;
import play.mvc.*;
import play.data.validation.*;
import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Calendrier extends Model {

    public Calendar calendar;
	public String now;
    public Locale locale;
    public List<String> days;
    public SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public Calendrier(){
    	this.calendar = new GregorianCalendar(2016, 9, 31);
    	Date date = new Date();
    	this.now = dateFormat.format(date);
    	this.locale = new Locale("Fr");
    	this.days = CalendrierService.getDays(calendar, locale);
    }
}
