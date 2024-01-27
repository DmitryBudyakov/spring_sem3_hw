package ru.geekbrains.sem3_hw.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.sem3_hw.domain.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public List<User> getUsers(){
        return users;
    }

    public void setUsers(List<User> users){
        this.users = users;
    }
}
