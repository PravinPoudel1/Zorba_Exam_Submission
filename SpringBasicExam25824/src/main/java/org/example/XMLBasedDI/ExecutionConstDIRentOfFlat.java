package org.example.XMLBasedDI;
import org.example.XMLBasedDI.ConstructorDIXmlBased.RentOfFlat;
import org.example.XMLBasedDI.SetterDIXmlBased.SelfOwnedFlat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


public class ExecutionConstDIRentOfFlat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        RentOfFlat rentOfFlat = context.getBean(RentOfFlat.class);
        System.out.println("**** RENT OF FLAT ***********");
        System.out.println("Enter number of person: ");
        int noOfPerson = sc.nextInt();
        rentOfFlat.printRentDetails(noOfPerson);


        System.out.println(" SELF OWNED FLAT ");
        System.out.println("Enter the dimensions : ");
        System.out.println("Length : ");
        float length = sc.nextFloat();
        System.out.println("breadth : ");
        float breadth = sc.nextFloat();
        System.out.println("Height : ");
        float height = sc.nextFloat();

        SelfOwnedFlat selfOwnedFlat = context.getBean(SelfOwnedFlat.class);

        selfOwnedFlat.printPriceDetails(10.5F,20.3F,30.5F);

    }






}

