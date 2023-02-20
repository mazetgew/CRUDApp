package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("")
public class HelloController {

    private final UserService userService;
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String startPage(Model model) {
        userService.add(new User("1", "1", "1", 1));
        userService.add(new User("2", "2", "2", 2));
        userService.add(new User("3", "3", "3", 3));
        model.addAttribute("title", "Table");
        model.addAttribute("users", userService.listUsers());
        return "users";
    }
    @GetMapping("/start")
    public String hello(Model model) {
        model.addAttribute("title", "Table");

        return "startPage";
    }
}