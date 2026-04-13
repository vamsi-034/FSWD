package com.example.Miniproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.Miniproject.profile.Profile;
import com.example.Miniproject.profile.Profiles;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

@Controller
public class Tectc {

    @Autowired
    private Mps mr;
    
    @Autowired
    Profiles ps;

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
        d.setPass(pe.encode(p)); // 🔐 encode password

        Profile pr=new Profile();
        pr.setFname(fn);
        pr.setEmail(em);
        
        mr.insert(d);
        ps.insert(pr);

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
    
    @GetMapping("/profile")
    public String profile(HttpSession h,Model m) {
        
    	Mp user =(Mp) h.getAttribute("user");
    	
    	if(user==null) {
    		return "redirect:/login";
    	}
    	
    	
    	Profile p=ps.findByEmail(user.getemail());
    	
    	m.addAttribute("profile",p);
    	
    	return "profile";
    } 
    
    @PostMapping("/updateAbout")
    public String updateAbout(@RequestParam("about") String about,
                              HttpSession h) {

        Mp user = (Mp) h.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        Profile p = ps.findByEmail(user.getemail());
        p.setAbout(about);

        ps.insert(p);   // save updated

        return "redirect:/profile";
    }
    
    @PostMapping("/updatePersonal")
    public String updatePersonal(@RequestParam("details") String details,
                                 HttpSession h) {

        Mp user = (Mp) h.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        Profile p = ps.findByEmail(user.getemail());
        p.setPersonal(details);

        ps.insert(p);

        return "redirect:/profile";
    }
    
    @PostMapping("/updateContact")
    public String updateContact(@RequestParam("phone") long phone,
                                HttpSession h) {

        Mp user = (Mp) h.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        Profile p = ps.findByEmail(user.getemail());

        p.setPhone(phone);

        ps.insert(p);

        return "redirect:/profile";
    }
    
    @PostMapping("/updateEducation")
    public String updateEducation(@RequestParam("education") String education,
                                  HttpSession h) {

        Mp user = (Mp) h.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        Profile p = ps.findByEmail(user.getemail());
        p.setEducation(education);

        ps.insert(p);

        return "redirect:/profile";
    }
    
    @PostMapping("/addCertificate")
    public String addCertificate(@RequestParam("name") String name,
                                 @RequestParam("image") String image,
                                 HttpSession h) {

        Mp user = (Mp) h.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        Profile p = ps.findByEmail(user.getemail());

        p.setCertificatename(name);
        p.setCertificateimage(image); // simple string for now

        ps.insert(p);

        return "redirect:/profile";
    }
}