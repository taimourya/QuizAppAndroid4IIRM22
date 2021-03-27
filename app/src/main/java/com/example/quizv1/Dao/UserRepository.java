package com.example.quizv1.Dao;

import com.example.quizv1.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IRepository<User>{

    private ArrayList<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        users.add(new User("taimourya", "taimouriya@gmail.com", "123"));
        users.add(new User("user", "user@gmail.com", "123"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findOneById(int id) {
        users.get(id);
        return null;
    }

    @Override
    public void add(User t) {
        users.add(t);
    }

    public User authentification(String username, String passwd)
    {
        for(User user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(passwd))
                return user;
        }

        return null;
    }
}
