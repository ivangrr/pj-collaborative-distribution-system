package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import com.avaje.ebean.Model;

@Entity
public class Article extends Model{
	@Id
	public Long id;
	
	public String code;
	public String name;
	public String description;
	
	@OneToMany
	public List<Article_Category> categoryList;
	
	@OneToMany
	public List<Article_Demand> demandList;
	
	public static Finder<Long, Article> find = new Finder<Long,Article>(Article.class);

}
