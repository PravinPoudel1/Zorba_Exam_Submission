package com.springmvcexam.service;

import com.mysql.cj.result.Row;
import com.springmvcexam.entity.Inventory;
import com.springmvcexam.entity.InventoryCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelExtractService {

    public static Map<InventoryCategory, List<Inventory>> excelToMap(XSSFWorkbook workbook) {
        Map<InventoryCategory, List<Inventory>> map = new HashMap<>();
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); //first line
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Inventory inventory = new Inventory();
            InventoryCategory inventoryCategory = new InventoryCategory();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                int posOfCell = cell.getColumnIndex();
                switch (posOfCell) {
                    case 0: //inventory category
                        inventoryCategory.setCategoryName(cell.getStringCellValue().trim());
                        break;
                    case 1: //inventory name
                        inventory.setInventoryName(cell.getStringCellValue().trim());
                        break;
                    case 2: //inventory quantity
                        inventory.setInventoryQuantity((int) cell.getNumericCellValue());
                        break;
                    case 3: //inventory price
                        inventory.setInventoryPrice(cell.getNumericCellValue());
                        break;
                    case 4: //inventory description
                        inventory.setInventoryDesc(cell.getStringCellValue());
                        break;
                }
            }
            if (map.containsKey(inventoryCategory)) {
                map.get(inventoryCategory).add(inventory);
            } else {
                List<Inventory> inventoryList = new ArrayList<>();
                inventoryList.add(inventory);
                map.put(inventoryCategory, inventoryList);
            }
        }
        return map;
    }


}
