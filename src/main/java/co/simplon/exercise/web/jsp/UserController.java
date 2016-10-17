package co.simplon.exercise.web.jsp;

import co.simplon.exercise.core.model.User;
import co.simplon.exercise.core.service.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public ModelAndView user(ModelMap model) {
        model.addAttribute("users", userService.getAll());
        return new ModelAndView("user");
    }

    @RequestMapping(path = "/add/user")
    public ModelAndView subscription(@RequestParam String username, @RequestParam String password, ModelMap model) {
        userService.addOrUpdateUserAndRoles(username, password, true, User.Role.USER);
        return new ModelAndView("redirect:/");
    }
    @RequestMapping(path = "/add")
    public ModelAndView add(@RequestParam String username, @RequestParam String password, @RequestParam User.Role role, ModelMap model) {
        userService.addOrUpdateUserAndRoles(username, password, true, role);
        return new ModelAndView("redirect:/user");
    }
    @RequestMapping(path = "/delete")
    public ModelAndView delete(@RequestParam String username, ModelMap model) {
        userService.deleteUser(username);
        return new ModelAndView("redirect:/user");
    }
}
