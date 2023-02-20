package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.UserService;

@Controller
@RequestMapping("")
public class HelloController {

    private final UserService userService;
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String startPage() {
        return "users";
    }
    @GetMapping("users")
    public String hello(Model model) {
        model.addAttribute("title", "Table");
        model.addAttribute("users", userService.listUsers());

        return "users";
    }
}