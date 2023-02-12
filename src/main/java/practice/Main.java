package practice;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        while (true) {

            System.out.println("Введите номер, имя или команду");
            Scanner scanner = new Scanner(System.in);
            String[] words = scanner.nextLine().replaceAll("[-,+]", "").split("\\s");
            String regexNumber = "[7-8][9]{1,3}[0-9]{7,9}";
            String regexName = "[А-Я][а-я]{1,20}";

            if (words.length == 1) {

                if (words[0].matches(regexName)) {

                    System.out.println("Введите номер телефона абонента " + words[0]);
                    String namber = scanner.nextLine();

                    if (namber.matches(regexNumber)){
                        phoneBook.addContact(namber, words[0]);
                    }

                    else{
                        System.out.println("");
                    }




                }

                if (words[0].matches(regexNumber)) {

                    System.out.println("Введите имя абонента для контакта " + words[0]);
                    String name = scanner.nextLine();
                    phoneBook.addContact(words[0], name);

                }

                if (words[0].equals("LIST")) {

                    for (String contact : phoneBook.getAllContacts()) {
                        System.out.println(contact);

                    }

                }


            }


        }


    }
}
