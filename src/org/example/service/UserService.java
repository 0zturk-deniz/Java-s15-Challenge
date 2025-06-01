package org.example.service;

import org.example.model.User;

import java.util.*;

public class UserService {
    private final Map<Integer, User> userMap = new HashMap<>();

    public void addUser(User user) {
        userMap.put(user.getId(), user);
        System.out.println("Kullanıcı eklendi: " + user);
    }

    public User getUserById(int id) {
        return userMap.get(id);
    }

    public List<User> getUserByName(String name) {
        List<User> results = new ArrayList<>();
        for (User user : userMap.values()) {
            if (user.getName().equalsIgnoreCase(name)) {
                results.add(user);
            }
        }
        return results;
    }

    public boolean deleteUser(int id) {
        if (userMap.containsKey(id)) {
            User removed = userMap.remove(id);
            System.out.println("Kullanıcı silindi:" + removed);
            return true;
        }
        return false;
    }

    public void printAllUsers() {
        System.out.println("Tüm kullanıcılar:");
        for (User user : userMap.values()) {
            System.out.println(user + ":" + user.whoYouAre());
        }
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }
}
