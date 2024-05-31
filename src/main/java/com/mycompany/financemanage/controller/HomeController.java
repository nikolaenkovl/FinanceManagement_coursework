package com.mycompany.financemanage.controller;
import com.mycompany.financemanage.model.User;
import com.mycompany.financemanage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(value="/")
    public String home(){
        return "home";
    }
    
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String goLogin(){
        return "login";
    }
    
    @PostMapping(value = "/register")
    public String register(@ModelAttribute User user, Model model) {
        if (userRepository.existsByUsername(user.getUsername()) || userRepository.existsByEmail(user.getEmail())) {
            // Ошибка - пользователь уже существует
            return "redirect:/register?error";
        }

        user.setRole("ROLE_ADMIN");
        userRepository.save(user);

        // Программная аутентификация
        Authentication auth = new UsernamePasswordAuthenticationToken(
                user, user.getPassword(), user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

        model.addAttribute("successMessage", "Registration successful!"); // Добавление сообщения об успешной регистрации в модель
        return "register";
    }

    @GetMapping(value = "/register")
    public String goRegister() {
        return "register";
    }
    
}
