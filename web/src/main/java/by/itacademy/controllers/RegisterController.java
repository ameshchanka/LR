package by.itacademy.controllers;

import by.itacademy.aspects.ErrorCatcher;
import by.itacademy.entity.User;
import by.itacademy.interfaces.ILeaseService;
import by.itacademy.service.UserService;
import org.omg.PortableInterceptor.ServerRequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @ErrorCatcher
    @GetMapping
    public String showRegisterPage(RedirectAttributes redirectAttributes) {
        return "register";
    }

    @ErrorCatcher
    @PostMapping
    public String getRegisterData(RedirectAttributes redirectAttributes,
                                  User user, Model model) {
        userService.save(user);
        return "redirect:/login";
    }
}
