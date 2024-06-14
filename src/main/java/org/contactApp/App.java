package org.contactApp;

import org.contactApp.dao.ContactDao;
import org.contactApp.dao.ContactDaoImpl;
import org.contactApp.entity.Contacts;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

        System.out.print("Enter Phone number : ");
        contacts.setPhoneNumber(scanner.nextLine());

        System.out.print("\nEnter Phone Name : ");
        contacts.setName(scanner.nextLine());

        System.out.print("\nEnter Phone Location : ");
        contacts.setLocation(scanner.nextLine());

        System.out.print("\nEnter Phone Email : ");
        contacts.setEmail(scanner.nextLine());

        int result=contactDao.addContact(contacts);
        System.out.println( "Number of records : "+ result );
    }
}
