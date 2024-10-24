package com.kingazm.com.flatmate.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class GlobalTasksController {

    @Autowired
    TaskService taskService;

    @GetMapping("/globalTasks")
    public String showGlobalTasks(Model model){
        model.addAttribute("tasks", taskService.findAll());
        return "globalTasks";
    }

}
