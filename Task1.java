package HomeWork.HomeWork_5;
//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.


import static HomeWork.numbersOneToN.number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {

  static Map<String, ArrayList<String>> telephoneBook = new HashMap<>();
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    operation();
    for (Map.Entry<String, ArrayList<String>> contact : telephoneBook.entrySet()) {
      System.out.printf("%s, %s\n", contact.getKey(), contact.getValue());

    }
  }

  private static void operation() {
    System.out.println("Введите операцию: \n1 - Добавить контакт\n2 - Добавить номер к контакту\n3 - Завершить");

    int numOperation = scanner.nextInt();
    if (numOperation == 1) {
      addContact();
    }
    if (numOperation == 2) {
      editContact();
    }
    if (numOperation == 3) {
      exitWork();
    }
  }

  private static void exitWork() {
    System.out.println("Все данные сохранены");
  }

  private static void addContact () {
    System.out.print("Введите ФИО абонента: ");
    String inputName = scanner.nextLine();
      if (telephoneBook.containsKey(inputName)) {
        System.out.println("Такой контакт уже существует");
      } else {
        ArrayList<String> number = new ArrayList<>();
        System.out.print("Введите номер ('w' - Возврат в меню): ");
        String inputNum = scanner.nextLine();
        while (!inputNum.equals("w")) {
          number.add(inputNum);
          inputNum = scanner.nextLine();
        }
        telephoneBook.put(inputName, number);
      }
      operation();
    }

  private static void editContact() {
    System.out.print("Введите ФИО абонента: ");
    String name = scanner.nextLine();
    if (!telephoneBook.containsKey(name)) {
      System.out.println("%sТакого контакта нет");
      operation();
    }
    else {
      System.out.print("Введите новый номер ('q' - ВЫХОД): ");
      String number = scanner.nextLine();

      while (!number.equals("q")) {
        telephoneBook.get(name).add(number);
        number = scanner.nextLine();
      }
    }
    operation();
  }
}
