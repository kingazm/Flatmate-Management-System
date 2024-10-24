package com.kingazm.com.flatmate.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String showDashboardDetails(Model model) throws ClassNotFoundException {

        model.addAttribute("dashboardTitle",  UserInfo.getLoggedUser().getUsername() + "'s dashboard - Flatmate Management System");
        //System.out.println("Dashboard title fetched");

        model.addAttribute("dashboardHeader", "Hello, " + UserInfo.getLoggedUser().getUsername());
        //System.out.println("Dashboard header fetched");

        String taskInfo = TaskService.showTheTask();
        model.addAttribute("taskInfo", taskInfo);

        return "dashboard";
    }

}
