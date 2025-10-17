package dev.ele;

import java.util.Collection;

import dev.ele.model.Contact;
import dev.ele.model.ContactData;

public class Main {
    public static void main(String[] args) {
        // Contact eleazar = new Contact("Eleazar", "test1@gmail.com", 8023463441L);
        // System.out.println(eleazar);

        // Contact bethel = new Contact("Bethel", "test2@gmail.com", 7013751979L);
        // System.out.println(bethel);
        // eleazar = eleazar.mergeContactData(bethel);
        // System.out.println(eleazar);

        // Contact eleazar2 = new Contact("Eleazar", "test3@gmail.com", 8023345275L);
        // eleazar = eleazar.mergeContactData(eleazar2);
        // System.out.println(eleazar);

        ContactData contactData = new ContactData();

        printData("Email Data", contactData.getData("email"));
        printData("Phone Data", contactData.getData("phone"));
    }

    public static void printData(String header, Collection<Contact> contacts) {
        System.out.println("--------------------------------------------");
        System.out.println(header);
        System.out.println("--------------------------------------------");
        contacts.forEach(System.out::println);
        System.out.println();
    }
}