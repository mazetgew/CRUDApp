package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class HelloController {

    @Autowired
    private final UserService userService;
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String hello(Model model) {
        User user1 = new User("Ivan", "Ivanov", "Policeman", 30);
        User user2 = new User("Ira", "Lyasheva", "Housewife", 0);
        User user3 = new User("Egor", "Lyashev", "Businessman", 1000);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        model.addAttribute("title", "Table");
        model.addAttribute("users", userService.listUsers());

        return "users";
    }
}
