package com.crm.main;

import java.util.Scanner;

import com.crm.service.CustomerService;
import com.crm.service.ProductService;
import com.crm.service.LeadService;

public class CRMApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CustomerService customerService = new CustomerService();
        ProductService productService = new ProductService();
        LeadService leadService = new LeadService();

        while (true) {

            System.out.println("\n====== CRM MENU ======");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Product");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead to Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    customerService.registerCustomer(name, email, phone);
                    break;

                case 2:
                    System.out.print("Enter Product Name: ");
                    String pname = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    productService.addProduct(pname, price);
                    break;

                case 3:
                    System.out.print("Enter Lead Name: ");
                    String lname = sc.nextLine();

                    System.out.print("Enter Source: ");
                    String source = sc.nextLine();

                    System.out.print("Enter Contact Info: ");
                    String contact = sc.nextLine();

                    leadService.createLead(lname, source, contact);
                    break;

                case 4:
                    System.out.print("Enter Lead ID: ");
                    Long leadId = sc.nextLong();

                    System.out.print("Enter Employee ID: ");
                    Long empId = sc.nextLong();

                    leadService.assignLeadToEmployee(leadId, empId);
                    break;

                case 5:
                    System.out.println("Exiting application...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}