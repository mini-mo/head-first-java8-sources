package lang;

public class IntegerTest {

  public static void main(String[] args) {
    test_bitCount();
    test_reverse();
    test_reverseBytes();
  }

  public static void test_bitCount() {
    int x = 0xaaaaaaaa;
    int y = 16;
//    int count = bitCount(x);
    int count = IntegerTest.bitCount(x);
    assertEquals(y, count);
  }

  public static int bitCount(int i) {
    int cnt = 0;
    while (i != 0) {
      i &= i - 1;
      cnt++;
    }
    return cnt;
  }

  public static void test_reverse() {
    int x = 0b10101010101010101010101010101010;
    int y = 0b01010101010101010101010101010101;
    int reversed = Integer.reverse(x);
    assertEquals(y, reversed);
  }

  public static void test_reverseBytes() {
    int x = 0b11000000001100000000110000000011;
    int y = 0b00000011000011000011000011000000;
    int reserved = Integer.reverseBytes(x);
    assertEquals(y, reserved);
  }

  public static void assertEquals(int expected, int result) {
    if (expected == result) {
      return;
    }
    System.err.println("test failure, expected " + expected + " but " + result);
  }
}
