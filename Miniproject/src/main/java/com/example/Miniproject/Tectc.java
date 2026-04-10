package com.example.Miniproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

@Controller
public class Tectc {

    @Autowired
    private Mps mr;

    @Autowired
    private PasswordEncoder pe;

    // ✅ HOME PAGE
    @GetMapping("/home")
    public String home(HttpSession h, Model m) {

        Mp user = (Mp) h.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        m.addAttribute("user", user);

        return "index";   // your main page
    }

    @GetMapping("/signup")
    public String signup() {
		return "signup";
    	
    }
    // ✅ SIGNUP
    @PostMapping("/Su")
    public String sign(@RequestParam("fname") String fn,
                       @RequestParam("em") String em,
                       @RequestParam("p") String p) {

        if (mr.existsByEmail(em)) {
            return "redirect:/?error=email_exists";
        }

        Mp d = new Mp();
        d.setFname(fn);
        d.setemail(em);
        d.setPass(pe.encode(p));   // 🔐 encode password

        mr.insert(d);

        return "redirect:/login";
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public String login(@RequestParam("em") String em,
                        @RequestParam("p") String p,
                        HttpSession h) {

        Mp user = mr.findByEmail(em);

        if (user == null) {
            return "redirect:/login?error=nouser";
        }

        if (pe.matches(p, user.getPass())) {
            h.setAttribute("user", user);   // ✅ store in session
            return "redirect:/home";
        } else {
            return "redirect:/login?error=wrongpass";
        }
    }

    // ✅ LOGOUT
    @GetMapping("/logout")
    public String logout(HttpSession h) {
        h.invalidate();
        return "redirect:/login";
    }

    // ✅ LOGIN PAGE (GET)
    @GetMapping("/login")
    public String loginPage() {
        return "login";   // login.html
    }

    // ✅ DEFAULT PAGE
    @GetMapping("/")
    public String index(HttpSession h, Model m) {

        Mp user = (Mp) h.getAttribute("user");

        m.addAttribute("user", user);   // allows navbar to show user

        return "index";
    }
}