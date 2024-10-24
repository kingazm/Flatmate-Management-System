package com.kingazm.com.flatmate.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @Autowired
    public TaskService taskService;

    @GetMapping("/taskAddition")
    public String showTaskForm(Model model) {
        //makes the task form ready to receive data used to maintain the registry of tasks
        model.addAttribute("task", new Task());
        return "taskAddition"; //destination link ;
    }

    @PostMapping("/taskAddition")
    public String submitTaskForm(@ModelAttribute("task") Task task) throws ClassNotFoundException {
        //adds a new task to task database table, so that it can be viewed and marked with progress
        TaskService.saveTheTask(task);
        return "taskAddition";
    }

    //new display
    @GetMapping("/tasks") //wlasciwie showUsers nie all by nie mylic!!!!!!
    public String showAll(Model model) { //wersja wyswietlajaca po wierszach, zamiast jednego stringa
        model.addAttribute("tasksTitle", UserInfo.getLoggedUser().getUsername() + "'s tasks - Flatmate Management System"); //title od the page
        model.addAttribute("tasks", taskService.findUserTasks());
        return "tasks";
    }

    @PostMapping("/taskDeletion/{id}")
    public String delete(@PathVariable int id) throws ClassNotFoundException { //trzeba zdobyc taska z thymeleafa! przechwycic
        taskService.deleteTheTask(id);

        return "redirect:/tasks";
    }


}
