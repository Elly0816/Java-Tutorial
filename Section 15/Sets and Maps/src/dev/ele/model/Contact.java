package dev.ele.model;

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
        return name + ", " + emails + ", " + phones + "\n";
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Contact other = (Contact) o;

        return getName().equals(other.getName());
    }

    @Override
    public int hashCode() {
        return 31 * getName().hashCode();
    }

    public void addEmail(String companyName) {
        if (companyName == null)
            return;
        String[] names = name.split(" ");
        String email = "%c%s@%s.com".formatted(name.charAt(0), names[names.length - 1],
                companyName.replaceAll(" ", "").toLowerCase());

        if (!emails.add(email)) {
            System.out.println(name + " already has email " + email);
        } else {
            System.out.println(name + " now has email " + email);
        }
    }

    public void replaceEmailIfExists(String oldEmail, String newEmail) {
        if (emails.contains(oldEmail)) {
            Set<String> newEmails = new HashSet<>(emails);
            newEmails.remove(oldEmail);
            newEmails.add(newEmail);
            emails = newEmails;
        }
    }
}