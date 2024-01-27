package ru.geekbrains.sem3_hw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.sem3_hw.domain.User;
import ru.geekbrains.sem3_hw.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер обработки задач
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calculate");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUserByAge(){
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Отфильтровывает пользователей по возрасту
     * @param age
     * @return
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age){
        return service.filterUsersByAge(service.getRepository().getUsers(), age);
    }

    /**
     * Вычисляет средний возраст пользователей
     * @return
     */
    @GetMapping("/calc")
    public double calculateAverageAge(){
        return service.calculateAverageAge(service.getRepository().getUsers());
    }
}
