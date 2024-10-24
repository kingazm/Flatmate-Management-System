package com.kingazm.com.flatmate.system;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
public class UserInfo {

    public static UserDetails getLoggedUser() { //returns currently logged-in user (UserDetails object)
        //System.out.println("User fetched");
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    //UserDetails has a getUsername() method

}
