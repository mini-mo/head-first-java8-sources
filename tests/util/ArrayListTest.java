package util;

import java.util.ArrayList;

public class ArrayListTest {

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>(10);
    try {
      list.set(2, "2");
    } catch (IndexOutOfBoundsException e) {
      e.printStackTrace();
    }
  }
}
