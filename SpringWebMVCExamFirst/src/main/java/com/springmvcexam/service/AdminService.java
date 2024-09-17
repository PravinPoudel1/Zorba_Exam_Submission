package com.springmvcexam.service;

import com.springmvcexam.entity.Inventory;
import com.springmvcexam.model.Customer;
import com.springmvcexam.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {




    private List<Customer> customers = new ArrayList<>();
    private List<Vendor> vendors = new ArrayList<>();
    private List<Inventory> inventoryList = new ArrayList<>();


    public AdminServiceImpl() {

        customers.add(new Customer(1, "Customer A"));
        customers.add(new Customer(2, "Customer B"));

        // Populating dummy vendors
        vendors.add(new Vendor(1, "Vendor A"));
        vendors.add(new Vendor(2, "Vendor B"));

        // Populating dummy inventory
        inventoryList.add(new Inventory(1, "Product A", 10));
        inventoryList.add(new Inventory(2, "Product B", 20));
    }

    // Method to validate admin credentials
    @Override
    public boolean validateAdmin(String username, String password, String role) {

        return "admin".equals(username) && "password".equals(password) && "Admin".equals(role);
    }


    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }


    @Override
    public List<Vendor> getAllVendors() {
        return vendors;
    }


    @Override
    public List<Inventory> getInventoryDetails() {
        return inventoryList;
    }


    @Override
    public void removeCustomer(int customerId) {
        customers.removeIf(customer -> customer.getId() == customerId);
    }


    @Override
    public void removeVendor(int vendorId) {
        vendors.removeIf(vendor -> vendor.getId() == vendorId);
    }


}

