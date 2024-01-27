package ru.geekbrains.sem3_hw.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.sem3_hw.domain.User;

@Service
public class UserService {

    private NotificationService notificationService;

    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Создает пользователя
     * @param name
     * @param age
     * @param email
     * @return
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        notificationService.notifyUser(user);

        return user;
    }
}
