package com.springmvcexam.controller;
import com.springmvcexam.Model.UserModel;
import com.springmvcexam.Model.InventoryModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping("/vendor")
public class VenderController {

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("vendor", new UserModel());
        return "vendorLogin";
    }

    @PostMapping("/login")
    public String validateLogin(@ModelAttribute("vendor") UserModel vendor, Model model) {
        if (vendor.getUsername().equals("vendorUsername") &&
                vendor.getPassword().equals("vendorPassword") &&
                vendor.getRole().equals("Vendor")) {
            return "redirect:/vendor/addInventory";
        } else {
            model.addAttribute("error", "Invalid credentials!");
            return "vendorLogin";
        }
    }

    @GetMapping("/addInventory")
    public String showAddInventoryPage(Model model) {
        model.addAttribute("inventory", new InventoryModel());
        return "addInventory";
    }

    @PostMapping("/saveInventory")
    public String saveInventory(@ModelAttribute("inventory") InventoryModel inventory,
                                @RequestParam("image") MultipartFile imageFile,
                                Model model) {

        if (inventory.getCategory().isEmpty() ||
                inventory.getName().isEmpty() ||
                inventory.getQuantity() <= 0 ||
                inventory.getPrice() <= 0 ||
                imageFile.isEmpty() ||
                inventory.getDescription().isEmpty()) {

            model.addAttribute("error", "Incomplete Inventory Data, please recheck!!");
            return "addInventory";
        }



        return "redirect:/vendor/inventorySuccess";
    }


}
