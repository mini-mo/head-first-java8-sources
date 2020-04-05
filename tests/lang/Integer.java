package lang;

public class Integer {

  public static void main(String[] args) {
    test_reverse();
    test_reverseBytes();
  }

  public static void test_reverse() {
    int x = 0b10101010101010101010101010101010;
    int y = 0b01010101010101010101010101010101;
    int reversed = java.lang.Integer.reverse(x);
    assertEquals(y, reversed);
  }

  public static void test_reverseBytes() {
    int x = 0b11000000001100000000110000000011;
    int y = 0b00000011000011000011000011000000;
    int reserved = java.lang.Integer.reverseBytes(x);
    assertEquals(y, reserved);
  }

  public static void assertEquals(int expected, int result) {
    if (expected == result) {
      return;
    }
    System.err.println("test failure, expected " + expected + " but " + result);
  }
}
