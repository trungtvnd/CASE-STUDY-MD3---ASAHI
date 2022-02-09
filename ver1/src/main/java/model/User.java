package model;

import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private LocalDate birth;
    private String email;
    private String phoneNumber;
    private String image;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id, String name, LocalDate birth, String email, String phoneNumber, String image) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.image = image;
    }

    public User(String name, LocalDate birth, String email, String phoneNumber, String image) {
        this.name = name;
        this.birth = birth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
