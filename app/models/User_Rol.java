package models;

import javax.persistence.*;

import com.avaje.ebean.Model;

@Entity
public class User_Rol extends Model {
	@Id
	public Long id;
	
	@ManyToOne
	public User userId;
	
	@ManyToOne
	public Rol rolId;
}
