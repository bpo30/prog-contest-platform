package ru.itmo.wp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmo.wp.domain.User;
import ru.itmo.wp.service.UserService;

import javax.servlet.http.HttpSession;


@Controller
public class UserPage extends Page {
    private final UserService userService;

    public UserPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public String userById(@PathVariable(required = false) String id, Model model) {
        try {
            User user = userService.findById(Long.parseLong(id));
            model.addAttribute("userEntity", user);
        } catch (NumberFormatException e) {
            // No operations.
        }
        return "UserPage";
    }

    @GetMapping("/user")
    public String userByIdBlank() {
        return "UserPage";
    }

    @PostMapping("/user/{userId}")
    public String disableUser(@PathVariable String userId, String method, HttpSession session) {
        try {
            long id = Long.parseLong(userId);
            if (method.equals("Disable")) {
                userService.disableUser(id);
            } else if (method.equals("Enable")) {
                userService.enableUser(id);
            }
        } catch (NumberFormatException e) {
            // No operations.
        }
        return "redirect:/users/all";
    }

}
