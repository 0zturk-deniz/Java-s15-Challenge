package org.example.model;

public class StaffUser extends User {
    public StaffUser(String name) {
        super(name);
    }

    @Override
    public String whoYouAre() {
        return "Staff";
    }
}
