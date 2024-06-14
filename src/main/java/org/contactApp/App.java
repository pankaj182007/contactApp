package org.contactApp;

import org.contactApp.dao.ContactDao;
import org.contactApp.dao.ContactDaoImpl;
import org.contactApp.entity.Contacts;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("contactConfig.xml");
        ContactDao contactDao =context.getBean("contactDaoImpl", ContactDaoImpl.class);

        Scanner scanner=new Scanner(System.in);
        Contacts contacts=new Contacts();

        System.out.println("---------------Welcome to Contact App--------------");
        int exit =0;
        while(exit==0) {
            System.out.print("To Add contact : Press 1\n" +
                    "To View all contact : Press 2\n" +
                    "To search contact by Phone number : Press 3\n" +
                    "To Update contact : Press 4\n" +
                    "To Delete contact : Press 5\n" +
                    "To Exit App : Press 0\n\n" +
                    "Enter your Choice : ");

            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:

                    System.out.print("Enter Phone number : ");
                    contacts.setPhoneNumber(scanner.nextLine());

                    System.out.print("\nEnter Phone Name : ");
                    contacts.setName(scanner.nextLine());

                    System.out.print("\nEnter Phone Location : ");
                    contacts.setLocation(scanner.nextLine());

                    System.out.print("\nEnter Phone Email : ");
                    contacts.setEmail(scanner.nextLine());

                    int result = contactDao.addContact(contacts);
                    System.out.println("Number of records : " + result);
                    break;

                case 0:
                    exit = 10;
                    break;

            }
        }
    }
}
