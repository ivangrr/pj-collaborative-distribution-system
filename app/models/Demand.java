package models;

import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Model;

@Entity
public class Demand extends Model {
	@Id
	public Long id;
	
	public String code;
	public String name;
	public String description;
	
	@OneToMany
	public List<Article_Demand> articleList;
	
	public static Finder<Long, Demand> find = new Finder<Long,Demand>(Demand.class);
}
