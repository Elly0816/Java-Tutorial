package dev.ele.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Contact {
    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();

    public Contact(String name) {
        this(name, null);
    }

    public Contact(String name, String email) {
        this(name, email, 0);
    }

    public Contact(String name, long phone) {
        this(name, null, phone);
    }

    public Contact(String name, String email, long phone) {
        this.name = name;
        if (email != null) {
            emails.add(email);
        }
        if (phone > 0) {
            String strPhone = String.valueOf(phone);
            String formattedPhone = "(%s)%s-%s".formatted(strPhone.substring(0, 3), strPhone.substring(3, 6),
                    strPhone.substring(6));
            phones.add(formattedPhone);
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "\nname: " + name + ", emails: " + emails + ", phones: " + phones;
    }

    public Contact mergeContactData(Contact contact) {
        if (name.equals(contact.name)) {
            // emails.addAll(contact.emails);
            // phones.addAll(contact.phones);
            // return this;
            Contact newContact = new Contact(name);
            newContact.emails = new HashSet<>(emails);
            newContact.phones = new HashSet<>(phones);
            newContact.emails.addAll(contact.emails);
            newContact.phones.addAll(contact.phones);
            return newContact;
        }

        Contact currCon = new Contact(name);
        currCon.emails = new HashSet<>(emails);
        currCon.phones = new HashSet<>(phones);
        return currCon;
    }
}