package co.simplon.exercise.web.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.simplon.exercise.core.model.Person;
import co.simplon.exercise.core.service.business.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping
	public ModelAndView person(ModelMap model) {
		model.addAttribute("persons", personService.getAll());
		return new ModelAndView("person", model);
	}

	@RequestMapping(path = "/add")
	public ModelAndView addPerson(@RequestParam String name, @RequestParam String surname, ModelMap model) {
		personService.addOrUpdate(new Person(name, surname));
		return new ModelAndView("redirect:/person");
	}

	@RequestMapping(path = "/delete")
	public ModelAndView addPerson(@RequestParam Integer id, ModelMap model) {
		personService.delete(id);
		return new ModelAndView("redirect:/person");
	}

}
