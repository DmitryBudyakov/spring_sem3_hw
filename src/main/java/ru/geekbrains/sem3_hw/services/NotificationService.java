package ru.geekbrains.sem3_hw.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.sem3_hw.domain.User;

@Service
public class NotificationService {

    /**
     * Оповещает о создании пользователя
     * @param user
     */
    public void notifyUser(User user){
        System.out.println("A new user has been created: " + user.getName());
    }

}
