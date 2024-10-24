package com.kingazm.com.flatmate.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShoppingController {

    @Autowired
    public ShoppingService shoppingService;

    @GetMapping("/shoppingList")
    public String showShoppingLists(Model model){
        model.addAttribute("flatShoppingList", shoppingService.findFlatList());
        model.addAttribute("userShoppingList", shoppingService.findPersonalList());
        return "shoppingList";
    }

    @GetMapping("/shoppingListItemAddition")
    public String showTaskForm(Model model) {

        model.addAttribute("item", new ShoppingItem());
        System.out.println("mapped");
        return "shoppingListItemAddition";
    }


    @PostMapping("/commonItemDeletion/{item}")
    public String deleteCommonItem(@PathVariable String item){
        //System.out.println("item deletion started...");
        shoppingService.deleteCommonItem(item);

        return "redirect:/shoppingList";
    }

    @PostMapping("/userItemDeletion/{item}")
    public String deleteUserItem(@PathVariable String item){
        //System.out.println("item deletion started...");
        shoppingService.deleteUserItem(item);

        return "redirect:/shoppingList";
    }

    @PostMapping("/shoppingListItemAddition")
    public String submitListForm(@ModelAttribute("item") ShoppingItem item) throws ClassNotFoundException {

        //for common - do common
        //for personal list - do personal

        shoppingService.saveTheItem(item);

        System.out.println("shop addition");

        return "shoppingListItemAddition";
    }

}
