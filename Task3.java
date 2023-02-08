package HomeWork.HomeWork_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3 {
  static ArrayList<Integer> list = new ArrayList<>(
      List.of(43, 41, 9, 17, 34, 12, 31, 14, 28, 44, 58, 37, 53, 69));

  public static void main(String[] args) {
    System.out.println(list);

    ArrayList<Integer> sortedList = heapSort(list, list.size());
    System.out.println(sortedList);
  }

  private static ArrayList<Integer> heapSort(ArrayList<Integer> list, int length) {
    if (length == 1) return list;
    int lastParent = findLastParentIndex(length);

    for (int parent = lastParent; parent >= 0; parent--) {
      int leftChild = parent * 2 + 1;
      int rightChild = parent * 2 + 2;

      if (leftChild == length - 1) rightChild = leftChild;

      int max = leftChild;
      if (list.get(rightChild) > list.get(max)) max = rightChild;

      if (list.get(parent) < list.get(max)) swapIndexes(list, max, parent);
    }
    swapIndexes(list, 0, length - 1);
    return heapSort(list, length - 1);
  }

  private static void swapIndexes(ArrayList<Integer> list, int i, int j) {
    Collections.swap(list, i, j);
  }

  private static int findLastParentIndex(int listSize) {
    int i;
    if (listSize % 2 == 0) {
      i = (listSize - 1) / 2;
    } else {
      i = (listSize - 2) / 2;
    }
    return i;
  }
}