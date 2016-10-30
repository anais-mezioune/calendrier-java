package models;

import java.util.*;

import play.*;
import play.mvc.*;
import play.data.validation.*;
import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Calendrier extends Model {

    public Calendar calendrier = new GregorianCalendar(2016, 9, 31);;
	public Date now;
    public Locale locale = new Locale("Fr");;
    public List<String> days = getDays(calendrier, locale);
    

}
