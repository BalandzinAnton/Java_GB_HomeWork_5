package HomeWork.HomeWork_5;

//Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task2 {
  static String s = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";

  public static void main(String[] args) {

    ArrayList<String> list = new ArrayList<>();

    String ss = s.replaceAll(",", "");
    System.out.println(ss);

    String[] sSplit = ss.split(" ");

    for (int i = 0; i < sSplit.length; i++) {
      list.add(sSplit[i]);
      i++;
    }

    Map<String, Long> frequency = list.stream().collect(
        Collectors.groupingBy(Function.identity(), Collectors.counting()));
    frequency.forEach((k, v) -> System.out.println(k + ": " + v));
  }

}