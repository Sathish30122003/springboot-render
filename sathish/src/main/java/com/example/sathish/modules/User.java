package com.example.sathish.modules;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

@Component
@Document(collection="user")
public class User {

    @Field
    private String password;
    @Field
    private String name;
    @Id
    private String email;
    @Field
    private String place;

    @Field
    private String occupation;
    @Field
    private String fathername;
    
    @Field
    private String mothername;
    @Field
    private String profilelink;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Field
    private String hobby;
    @Field
    private String date; 
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

   
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public String getProfilelink() {
        return profilelink;
    }

    public void setProfilelink(String profilelink) {
        this.profilelink = profilelink;
    }



    public User() {
    }

    public User(String password, String name, String email, String place) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.place = place;
    }


    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return String.format("User[name='%s', email='%s', password='%s', place='%s']", name,email,password, place);
    }
}
