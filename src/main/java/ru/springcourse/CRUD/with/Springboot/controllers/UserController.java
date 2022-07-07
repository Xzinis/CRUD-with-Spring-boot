package ru.springcourse.CRUD.with.Springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.springcourse.CRUD.with.Springboot.models.User;
import ru.springcourse.CRUD.with.Springboot.service.UserService;
import ru.springcourse.CRUD.with.Springboot.service.UserServiceImp;


import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("User", userService.findOne(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("User") User user) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("User") @Valid User user) {
        userService.save(user);
        return "redirect:/";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("User", userService.findOne(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("User") @Valid User user,
                         @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}