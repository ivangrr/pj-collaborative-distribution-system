package models;

import javax.persistence.*;
import com.avaje.ebean.Model;

@Entity
public class Article_Demand extends Model {
	@Id
	public Long id;
	
	@ManyToOne
	public Article article;
	
	@ManyToOne
	public Demand demand;
}
