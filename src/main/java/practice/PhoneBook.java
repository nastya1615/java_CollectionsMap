package practice;

import java.util.*;

public class PhoneBook {

    TreeMap<String, String> contact = new TreeMap<>();
    String regexNumber = "[7-8][9]{1,3}[0-9]{7,9}";
    String regexName = "[А-Я][а-я]{1,20}";


    public void addContact(String phone, String name) {

        if (phone.matches(regexNumber) & name.matches(regexName)) {
            contact.put(phone, name);
        }

    }


    public String getContactByPhone(String phone) {

        return contact.get(phone) + " - " + phone;


    }


    public Set<String> getContactByName(String name) {

        TreeSet<String> number = new TreeSet<>();

        for (String key : contact.keySet()) {

            if (contact.get(key).equals(name)) {

                number.add(name + " - " + key);
            }


        }


        return number;
    }

    public Set<String> getAllContacts() {


        TreeSet<String> number = new TreeSet<>();

        HashMap<String, String> newHasMap = new HashMap<>();

        String num;

        for (String key : contact.keySet()) {

            num = key;

            if (newHasMap.containsKey(contact.get(key))) {

                num = newHasMap.get(contact.get(key)) + ", " + num;


            }


            newHasMap.put(contact.get(key), num);

        }


        for (String name : newHasMap.keySet()) {

            number.add(name + " - " + newHasMap.get(name));

        }

        return number;
    }


}