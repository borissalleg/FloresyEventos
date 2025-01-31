// package com.floristeria.v1.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// import com.floristeria.v1.Service.UserService;
// import com.floristeria.v1.model.User;

// @Controller
// @RequestMapping("/register")
// public class RegisterController {   

//     @Autowired
//     private UserService userService;

//     @GetMapping
//     public String showRegistrationForm(Model model) {
//         model.addAttribute("user", new User());
//         return "registerForm";
//     }

//     @PostMapping
//     public String registerUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
//         userService.saveUser(user); // Método para guardar el usuario
//         redirectAttributes.addFlashAttribute("message", "Usuario registrado con éxito!");
//         return "redirect:/home/index";
//     }
// }

