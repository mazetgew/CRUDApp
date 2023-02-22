package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class HelloController {

    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public String startPage(Model model) {
        model.addAttribute("title", "Table");
        model.addAttribute("users", userService.listUsers());
        return "addUser";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "show";
    }

    @GetMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/getAll";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.update(user);
        return "redirect:/getAll";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id, @ModelAttribute User user) {
        userService.remove(user);
        return "redirect:/getAll";
    }
}