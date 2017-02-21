package models;

import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.Model;

@Entity
public class User extends Model {
	@Id
	public Long id;
	
	public String userName;
	public String firstName;
	public String lastName;
	public String password;
	
	@OneToMany
	public List<User_Rol> userRoles;
}
