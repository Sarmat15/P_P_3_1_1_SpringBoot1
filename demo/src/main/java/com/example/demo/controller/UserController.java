package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserDaoService userService;

    @Autowired
    public UserController(UserDaoService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("user", userService.getUsersList());
        return "users";
    }

    @GetMapping(value = "/editUser/{id}")
    public String editUser(@PathVariable Long id, ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @GetMapping(value = "/addUser")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @RequestMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @PostMapping(value = "/editUser/{getId}")
    public String saveEditUser(@PathVariable Long getId, @ModelAttribute("user") User user) {
        user.setId(getId);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping(value = "/addUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }


}
