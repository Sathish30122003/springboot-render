package com.example.sathish.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sathish.modules.User;
import com.example.sathish.repository.UserRepository;

@Service
public class UserService { // Capitalized the class name
    User user=null;
    @Autowired
    private UserRepository userRepository; // Renamed variable for clarity

    public void save(User u) {
        userRepository.save(u);
    }

    public boolean verifyUser(String email, String password) {
        user = userRepository.findByEmail(email);
        if (user != null && user.getpassword().equals(password)) { // Assuming User has a getPassword() method
            return true; // Verification successful
        }
        return false; // Verification failed
    }
    public User profile(){
        return user;
    }

    public void updateUserDetails(String fathername,String mothername, String occupation, String dob, String profileImageLink,String hobby) {
        if (user != null) {
            user.setOccupation(occupation);
            user.setFathername(fathername);
            user.setMothername(mothername);
            user.setHobby(hobby);
            user.setProfilelink(profileImageLink);
            user.setDate(dob);
            userRepository.save(user);
        }
        
    }
    public String getname(){
        String name=user.getName();
        return name;
    }

}
