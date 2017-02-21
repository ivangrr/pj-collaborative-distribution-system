package models;

import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Model;

@Entity
public class Category extends Model {
	@Id
	public Long id;
	
	public String code;
	public String name;
	
	@OneToMany
	public List<Article_Category> articleList;
}
