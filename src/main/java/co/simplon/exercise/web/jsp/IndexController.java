package co.simplon.exercise.web.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping
	public ModelAndView index(ModelMap model) {
		return new ModelAndView("redirect:/person");
	}

}
