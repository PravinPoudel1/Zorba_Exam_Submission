package org.example.annotation_based.execution;

import org.example.annotation_based.entity.Customers;
import org.example.annotation_based.entity.Products;
import org.example.annotation_based.entity.ProductsType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {

        //Read the Configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        //create SessionFactory Object from Configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Customer ID (C01): ");
            String custId = scanner.nextLine();
            validateCustomerId(custId);

            System.out.println("Enter Customer Name: ");
            String custName = scanner.nextLine();

            System.out.println("Enter Customer Email: ");
            String custEmail = scanner.nextLine();

            System.out.println("Enter Customer  Mobile Number: ");
            long custMobile = scanner.nextLong();
            validatePhoneNumber(custMobile);

            System.out.println("Enter Product ID ( P01): ");
            String productId = scanner.nextLine();
            validateProductId(productId);

            System.out.println("Enter Product Name: ");
            String productName = scanner.nextLine();

            System.out.println("Enter Product Type (grocery/chocolate/cosmetics): ");
            String productType = scanner.nextLine();

            System.out.println("Enter Product Quantity: ");
            double productQuantity = scanner.nextDouble();

            session.beginTransaction();

            ProductsType pt = (ProductsType) session.createQuery("FROM ProductsType WHERE produceType = :productType")
                    .setParameter("productType", productType).uniqueResult();
            if (pt != null) {
                System.out.println("Invalid product type!");
                return;

            }
            double totalPrice = pt.getRate() * productQuantity;

            Customers customers = new Customers();
            customers.setCustId(custId);
            customers.setCustName(custName);
            customers.setCustEmail(custEmail);
            customers.setCustMobile(String.valueOf(custMobile));
            customers.setFinalProductPrice(totalPrice);

            Products products = new Products();
            products.setProductId(productId);
            products.setProductName(productName);
            products.setProductQuantity((int) productQuantity);
            products.setCustomers(customers);
            products.setProductsType(pt);

            session.save(products);
            session.save(customers);

            session.getTransaction().commit();
            System.out.println("Data has been saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Validation Error: " + e.getMessage());
        }finally {
            session.close();
            sessionFactory.close();
        }

    }

    private static void validateProductId(String productId) {
    }

    private static void validatePhoneNumber(long custMobile) {
    }


    private static void validateCustomerId(String custId) {

        }

        class InvalidCustomerIdException extends Exception{
        public InvalidCustomerIdException(String message) {
            super(message);
        }
        }
        class InvalidProductIdException extends Exception{
        public InvalidProductIdException(String message) {
            super(message);
        }
        }
        class InvalidPhoneNumberException extends Exception{
        public InvalidPhoneNumberException(String message) {
            super(message);
        }
        }

    }

