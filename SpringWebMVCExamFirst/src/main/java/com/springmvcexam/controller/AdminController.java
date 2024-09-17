package com.springmvcexam.controller;

import com.springmvcexam.entity.Inventory;
import com.springmvcexam.model.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {


    @RequestMapping("/adminLogin")
    public String showLoginForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "adminLogin";
    }


    @PostMapping("/adminLogin")
    public String validateAdmin(@ModelAttribute("admin")  Admin admin, Model model) {
        if ("admin".equals(admin.getUsername()) && "password".equals(admin.getPassword()) && "Admin".equals(admin.getRole())) {
            return "adminDashboard";
        } else {
            model.addAttribute("error", "Invalid Credentials!");
            return "adminLogin";
        }
    }


    @RequestMapping("/inventory")
    public String showInventory(Model model) {

        model.addAttribute("inventoryList", getInventoryDetails());
        return "inventoryPage";
    }


    private List<Inventory> getInventoryDetails() {

        return Arrays.asList(new Inventory(1, "Product A", 10), new Inventory(2, "Product B", 20));
    }


}
