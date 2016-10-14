package co.simplon.exercise.core.model;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String surname;

	public Person() {
		// FOR HIBERNATE
	}

	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

}
