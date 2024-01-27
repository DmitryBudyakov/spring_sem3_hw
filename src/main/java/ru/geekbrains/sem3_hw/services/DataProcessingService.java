package ru.geekbrains.sem3_hw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.sem3_hw.domain.User;
import ru.geekbrains.sem3_hw.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }

    /**
     * Сортирует пользователей по возрасту
     *
     * @param users
     * @return
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Отфильтровывает пользователей по возрасту (старше указанного возраста)
     *
     * @param users
     * @param age
     * @return
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Считает средний возраст пользователей
     *
     * @param users
     * @return
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Добавляет пользователя в репозиторий
     * @param user
     */
    public void addUser(User user) {
        repository.getUsers().add(user);
    }
}
