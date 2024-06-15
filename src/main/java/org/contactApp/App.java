package org.contactApp;

import org.contactApp.dao.ContactDao;
import org.contactApp.dao.ContactDaoImpl;
import org.contactApp.entity.Contacts;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.Socket;
import java.util.List;
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
        int result=0;

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

                    System.out.print("\nEnter  Name : ");
                    contacts.setName(scanner.nextLine());

                    System.out.print("\nEnter  Location : ");
                    contacts.setLocation(scanner.nextLine());

                    System.out.print("\nEnter  Email : ");
                    contacts.setEmail(scanner.nextLine());

                     result = contactDao.addContact(contacts);
                    System.out.println("Number of records : " + result);
                    break;

                case 2:
                    List<Contacts> allContacts= contactDao.allContacts();
                    System.out.println("--------------All Contacts----------");
                    for (Contacts c:allContacts)
                    {
                        System.out.println(c);
                    }
                    break;
                case 3:
                    System.out.print("Enter Phone number : ");
                    contacts=contactDao.fetchContact(scanner.nextLine());
                    System.out.println(contacts.toString());
                    break;

                case 4:
                    System.out.print("Enter phone number : ");
                    String old=scanner.nextLine();

                    System.out.println("-------Enter New Details------");
                    System.out.print("\nEnter new phone number : ");
                    contacts.setPhoneNumber(scanner.nextLine());

                    System.out.print("\nEnter New Name : ");
                    contacts.setName(scanner.nextLine());

                    System.out.print("\nEnter New Location : ");
                    contacts.setLocation(scanner.nextLine());

                    System.out.print("\nEnter New Email : ");
                    contacts.setEmail(scanner.nextLine());

                     result=contactDao.updateContact(contacts,old);
                    System.out.println("Number of Row Uploaded : "+ result);

                    break;

                case 5:
                    System.out.print("Enter phone number : ");
                    result=contactDao.deleteContact(scanner.nextLine());
                    System.out.println("Number of row deleted : "+result);
                    break;

                case 0:
                    exit = 10;
                    break;

            }
        }
    }
}
