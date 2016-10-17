package co.simplon.exercise.core.service.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.simplon.exercise.core.model.Person;
import co.simplon.exercise.core.repository.PersonRepository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersonService {

	@Autowired
	public PersonRepository personRepository;

	@Transactional(readOnly = true)
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	@Transactional
	public Person addOrUpdate(Person person) {
		return personRepository.save(person);
	}

	@Transactional
	public void delete(Integer id) {
		personRepository.delete(id);
	}

}