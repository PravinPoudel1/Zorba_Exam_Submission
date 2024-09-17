package com.springmvcexam.controller;

import com.springmvcexam.entity.Inventory;
import com.springmvcexam.entity.InventoryCategory;
import com.springmvcexam.entity.User;
import com.springmvcexam.model.Customer;
import com.springmvcexam.service.CustomerService;
import com.springmvcexam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/vendor")
public class VendorController {

    @Autowired
    CustomerService customerService;

    @Autowired
   VendorService vendorService;

    @GetMapping("/vendorLogin")
    public ModelAndView vendorLogin() {
        return new ModelAndView("vendorLogin");
    }

    @PostMapping("/vendorDashboard")
    public ModelAndView vendorLogin(@RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    @RequestParam("roleName") String roleName) {
       Customer customer = this.customerService.getClass();
       ModelAndView modelAndView = new ModelAndView();
        if (user != null) {
            modelAndView.setViewName("vendorDashboard");
            modelAndView.addObject("userObj", user);
        } else {
            modelAndView.setViewName("vendorLogin");
            modelAndView.addObject("errorMessage", "Invalid user and password" +
                    "or not a qualified vendor");     }
       return modelAndView;
    }

    @PostMapping("/saveInventory")
    public ModelAndView saveInventory(@ModelAttribute Inventory inventory,
                                      @ModelAttribute InventoryCategory inventoryCategory) {
        return new ModelAndView("vendorDashboard");

    }

    @PostMapping("/uploadInventory")
    public String uploadInventoryFile(@RequestParam("file") MultipartFile file, Model model) {

        return "inventoryDashboard";
    }

    @GetMapping("/uploadImage/{itemId}")
    public String showUploadImageForm(@PathVariable("itemId") Long itemId, Model model) {
        model.addAttribute("itemId", itemId);
        return "invImage";
    }

    @PostMapping("/uploadImage/{itemId}")
    public String handleImageUpload(@PathVariable("itemId") Long itemId, @RequestParam("image") MultipartFile image) {

        return "redirect:/inventoryDashboard";


    }


}

