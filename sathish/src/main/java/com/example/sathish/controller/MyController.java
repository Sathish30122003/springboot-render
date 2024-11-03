package com.example.sathish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sathish.modules.Book;
import com.example.sathish.modules.User;
import com.example.sathish.service.BookService;
import com.example.sathish.service.UserService; // Update import

@Controller
public class MyController { // Renamed from controller to MyController
    @Autowired
    private UserService serviceUser; // Update variable name for clarity
    
    @Autowired
    private BookService servicebook; // Autowired BookService to avoid null

    @RequestMapping("/home")
    public String home(Model model) {
        String name=serviceUser.getname();
        model.addAttribute("username",name);
        return "home";
    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/submit_login")
    public String verify(@RequestParam("email") String email, @RequestParam("password") String password){
        if (serviceUser.verifyUser(email, password)) {
            return "redirect:/home"; // Redirect to home on successful login
        } else {
            return "redirect:/login?error"; // Redirect back to login with error message
        }
    }

    @PostMapping("/submit_signup")
    public String handleSignup(@ModelAttribute User u) {
        serviceUser.save(u); // Use the updated service name
        return "redirect:/login";
    }

    @RequestMapping("/postbook")
    public String postbook() {
        return "postbook";
    }

    @PostMapping("/submitBook")
    public String sav(@ModelAttribute Book b) {
            servicebook.save(b); 
            return "redirect:/home";
    }
    @RequestMapping("/user")
    public String user(Model model){
        User prof=serviceUser.profile();
        model.addAttribute("user", prof);
        return "user";
        
    }
    @RequestMapping("/additional")
    public String addtional(){
        return "additional";
    }

    @PostMapping("/submit_profile2")
public String updateUser(@RequestParam("fatherName") String fathername,
                         @RequestParam("motherName") String mothername,
                         @RequestParam("occupation") String occupation,
                         @RequestParam("dob") String dob,  // add dob if it's used in the service method
                         @RequestParam("profileImageLink") String profileImageLink,
                         @RequestParam("hobby") String hobby) {
    serviceUser.updateUserDetails(fathername, mothername, occupation, dob, profileImageLink,hobby); // adjust service call if needed
    return "redirect:/user";
}
@GetMapping("/books")
    public String listBooks(Model model) {
        List<Book> books = servicebook.getAllBooks();
        model.addAttribute("books", books);
        return "viewbooks";  // Points to the HTML template (book-list.html)
    }
}
