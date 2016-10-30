package models;

import services.CalendrierService;
import java.util.*;

import play.*;
import play.mvc.*;
import play.data.validation.*;
import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Calendrier extends Model {

    public Calendar calendar;
	public Date now;
    public Locale locale;
    public List<String> days;
    
    public Calendrier(){
    	this.calendar = new GregorianCalendar(2016, 9, 31);
    	this.now = new Date();
    	this.locale = new Locale("Fr");
    	this.days = CalendrierService.getDays(calendar, locale);
    }
}
