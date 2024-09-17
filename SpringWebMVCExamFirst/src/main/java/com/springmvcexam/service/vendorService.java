package com.springmvcexam.service;

import com.springmvcexam.dao.InventoryDAO;
import com.springmvcexam.entity.Inventory;
import com.springmvcexam.entity.InventoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class vendorService {

    Autowired
    InventoryDAO inventoryDAO;

    @Autowired
    InventoryCategoryDAO inventoryCategoryDAO;

    public boolean saveInventory(MultipartFile file) {
        XSSFWorkbook workbook = null;
        try {

            workbook = new XSSFWorkbook(file.getInputStream());
            Map<InventoryCategory, List<Inventory>> map =
                    ExcelExtractService.excelToMap(workbook);

            for(Map.Entry<InventoryCategory, List<Inventory>> entry : map.entrySet()) {
                InventoryCategory category = entry.getKey();
                List<Inventory> inventoryList = entry.getValue();

                InventoryCategory existingCategory =
                        inventoryCategoryDAO.getInventoryCategoryByName(category.getCategoryName());
                if(existingCategory == null) {
                    inventoryCategoryDAO.persistInventoryCategory(category);
                    existingCategory = category;
                }

                for (Inventory inventory : inventoryList) {
                    inventory.setInventoryCategory(existingCategory);
                    Inventory existingInventory =
                            inventoryDAO.getInventoryByName(inventory.getInventoryName());
                    if(existingInventory == null) {
                        inventoryDAO.persistInventory(inventory);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }


    public boolean saveSingleInventory(Inventory inventory,InventoryCategory inventoryCategory) {

        try {
            InventoryCategory existingCategory =
                    inventoryCategoryDAO.getInventoryCategoryByName(inventoryCategory.getCategoryName());
            if(existingCategory == null) {
                inventoryCategoryDAO.persistInventoryCategory(inventoryCategory);
                existingCategory = inventoryCategory;
            }
            inventory.setInventoryCategory(existingCategory);
            Inventory existingInventory =
                    inventoryDAO.getInventoryByName(inventory.getInventoryName());
            if(existingInventory == null) {
                inventoryDAO.persistInventory(inventory);
            }
            return true;
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public List<InventoryCategory> getInventoryCategories() {
        return inventoryCategoryDAO.getAllInventory();
    }



}
