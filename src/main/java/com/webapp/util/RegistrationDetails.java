package com.webapp.util;

public class RegistrationDetails {
    private String username;
    private String email;
    private String mobile;

    // Constructors, getters, and setters
    public RegistrationDetails(String username, String email, String mobile) {
        this.username = username;
        this.email = email;
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }
}
