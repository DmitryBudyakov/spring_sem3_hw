package ru.geekbrains.sem3_hw.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.sem3_hw.domain.User;

@Service
public class RegistrationService {

    UserService userService;
    DataProcessingService dataProcessingService;
    NotificationService notificationService;

    /**
     * Конструктор сервиса регистрации пользователя
     * @param userService
     * @param dataProcessingService
     * @param notificationService
     */
    public RegistrationService(UserService userService,
                               DataProcessingService dataProcessingService,
                               NotificationService notificationService) {
        this.userService = userService;
        this.dataProcessingService = dataProcessingService;
        this.notificationService = notificationService;
    }

    /**
     * Создание пользователя, запись его в репозиторий и извещение о создании
     * @param name
     * @param age
     * @param email
     */
    public void processUserRegistration(String name, int age, String email){
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUser(user);
        notificationService.notifyUser(user);
    }


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }
}
