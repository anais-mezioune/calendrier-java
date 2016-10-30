package models;

import java.util.*;

import play.*;
import play.data.validation.*;
import play.db.jpa.Model;

import javax.persistence.Entity;

public class Evenement extends Model{
	
	public String nom;
	public String description;
	
	public Evenement(@Required String nom, @Required String description){
		this.nom = nom;
		this.description = description;
	}
}
