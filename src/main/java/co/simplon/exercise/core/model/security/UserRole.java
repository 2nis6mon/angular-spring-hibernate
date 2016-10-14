package co.simplon.exercise.core.model.security;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	private User user;

	private String role;

	public UserRole() {
		// TODO for serialization
	}

	public UserRole(User user, String role) {
		this.user = user;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
