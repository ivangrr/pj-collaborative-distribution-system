package models;

import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Model;

@Entity
public class Rol extends Model {
	@Id
	public Long id;
	
	public String name;
	public String description;
	
	@OneToMany
	public List<User_Rol> userRoles;
}
