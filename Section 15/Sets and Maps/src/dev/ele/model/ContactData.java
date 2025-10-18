package dev.ele.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactData {

    // This class should return email data and phone data

    List<Contact> contactData = new ArrayList<>();

    private final String phoneData = """
            Charlie Brown, 33344455555
            Maid Marlon, 1234567890
            Mickey Mouse, 9998887777
            Mickey Mouse, 1247489758
            Minnie Mouse, 4567805666
            Robin Hood, 5647893000
            Robin Hood, 7899028222
            Lucy Van Pelt, 5642086852
            Mickey Mouse, 9998887777
            """;

    private final String emailData = """
            Mickey Mouse, mckmouse@gmail.com
            Mickey Mouse, micky1@aws.com
            Minnie Mouse, minnie@verizon.net
            Robin Hood, rhood@gmail.com
            Linus Van Pelt, lvpelt2015@gmail.com
            Daffy Duck, daffy@google.com
            """;

    public List<Contact> getData(String type) {

        boolean userWantsPhone = type.equalsIgnoreCase("phone");
        boolean userWantsEmail = type.equalsIgnoreCase("email");
        if (type == null || !(userWantsPhone || userWantsEmail)) {
            return null;
        }
        Scanner scanner = new Scanner(userWantsPhone ? phoneData : emailData);
        List<Contact> contactList = new ArrayList<>();
        while (scanner.hasNext()) {
            String[] data = scanner.nextLine().split(",");
            if (userWantsPhone) {
                contactList.add(new Contact(data[0].trim(), Long.parseLong(data[1].trim())));
            }
            if (userWantsEmail) {
                contactList.add(new Contact(data[0].trim(), data[1].trim()));
            }
        }
        scanner.close();
        return contactList;
        // if (getPhone) {
        // return withPhone(phoneData);
        // }

        // if (getEmail) {
        // return withEmail(emailData);
        // }
        // System.out.println("Invalid type");
        // return null;
    }

    // private List<Contact> withPhone(String phoneString) {
    // String[] phones = phoneString.split("\n");
    // List<String> phoneStringAsList = Arrays.asList(phones);
    // List<Contact> contacts = new ArrayList<>();
    // for (var data : phoneStringAsList) {
    // String name = data.trim().split(", ")[0];
    // long phone = Long.parseLong(data.trim().split(", ")[1]);
    // contacts.add(new Contact(name, phone));
    // }
    // return contacts;
    // }

    // private List<Contact> withEmail(String emailString) {
    // String[] emails = emailString.split("\n");
    // List<String> emailStringAsList = Arrays.asList(emails);
    // List<Contact> contacts = new ArrayList<>();
    // for (var data : emailStringAsList) {
    // String name = data.trim().split(", ")[0];
    // String email = data.trim().split(", ")[1];
    // contacts.add(new Contact(name, email));
    // }
    // return contacts;
    // }

}