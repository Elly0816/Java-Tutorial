package dev.ele;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dev.ele.model.Contact;
import dev.ele.model.ContactData;
import dev.ele.model.Task;
import dev.ele.model.Task.Employees;
import dev.ele.model.Task.Status;

public class Main {
    public static void main(String[] args) {

        Set<Task> tasksByAnn = Task.getTasks(Employees.ANN);
        printData("Ann's Tasks", tasksByAnn);
        Set<Task> allTasks = Task.getTasks();
        printData("All Tasks", allTasks);
        // System.out.println("Working dir: " + System.getProperty("user.dir"));

        // Contact eleazar = new Contact("Eleazar", "test1@gmail.com", 8023463441L);
        // System.out.println(eleazar);

        // Contact bethel = new Contact("Bethel", "test2@gmail.com", 7013751979L);
        // System.out.println(bethel);
        // eleazar = eleazar.mergeContactData(bethel);
        // System.out.println(eleazar);

        // Contact eleazar2 = new Contact("Eleazar", "test3@gmail.com", 8023345275L);
        // eleazar = eleazar.mergeContactData(eleazar2);
        // System.out.println(eleazar);

        // ContactData contactData = new ContactData();

        // List<Contact> emails = contactData.getData("email");
        // List<Contact> phones = contactData.getData("phone");

        // printData("Email List", emails);
        // printData("Phone List", phones);

        // Set<Contact> emailContacts = new HashSet<>(emails);
        // Set<Contact> phoneContacts = new HashSet<>(phones);

        // printData("Email Set", emailContacts);
        // printData("Phone Set", phoneContacts);
        // String companyName = "Odyssey";
        // addCompanyEmails(companyName, emailContacts);
        // addCompanyEmails(companyName, phoneContacts);
        // printData("Email Set", emailContacts);
        // printData("Phone Set", phoneContacts);

        // Contact mickeyMouse = emails.get(emails.indexOf(new Contact("Mickey
        // Mouse")));
        // mickeyMouse.addEmail(companyName);
        // mickeyMouse.replaceEmailIfExists("MMouse@odyssey.com", "MMouse@odyssey.org");
        // // printData("Email Set", emailContacts);
        // System.out.println(mickeyMouse);

        // // Union of both sets
        // Set<Contact> unionAB = new HashSet<>();
        // unionAB.addAll(emailContacts);
        // unionAB.addAll(phoneContacts);
        // printData("(A ∪ B) Union of emails (A) with phone (B)", unionAB);

        // // Elements that are both in phoneContacts and emailContacts
        // Set<Contact> intersectionAB = new HashSet<>(emailContacts);
        // intersectionAB.retainAll(phoneContacts);
        // printData("(A ∩ B) intersection of email (A) with phone (B)",
        // intersectionAB);

        // // elements in emailContacts that are not in phoneContacts
        // Set<Contact> AminusB = new HashSet<>(emailContacts);
        // AminusB.removeAll(phoneContacts);
        // printData("(A - B) email (A) minus phone (B)", AminusB);

        // // elements in phoneContacts that are not in emailContacts
        // Set<Contact> BminusA = new HashSet<>(phoneContacts);
        // BminusA.removeAll(emailContacts);
        // printData("(B - A) phone (B) minus email (A)", BminusA);

        // // elements that do not appear in both sets (el in A not in B and vice versa)
        // // Method 1
        // Set<Contact> symmetricDiff = new HashSet<>(AminusB);
        // symmetricDiff.addAll(BminusA);
        // printData("Elements that do not appear in both sets", symmetricDiff);

        // // Method 2
        // Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        // symmetricDiff2.removeAll(intersectionAB);
        // printData("Elements that do not appear in both sets", symmetricDiff2);

    }

    public static <T> void printData(String header, Collection<T> items) {
        System.out.println("--------------------------------------------");
        System.out.printf("%30s%n", header);
        System.out.println("--------------------------------------------");
        items.forEach(System.out::println);
        System.out.println();
    }

    public static void addCompanyEmails(String name, Collection<Contact> contacts) {
        contacts.forEach((c) -> c.addEmail(name));
    }
}