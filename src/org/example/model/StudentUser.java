package org.example.model;

public class StudentUser extends User {
    public StudentUser(String name) {
        super(name);
    }

    @Override
    public String whoYouAre() {
        return "Student";
    }
}
