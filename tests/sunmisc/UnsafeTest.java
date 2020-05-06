package sunmisc;

import static unit.Unit.assertEquals;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class UnsafeTest {

  public static Unsafe unsafe;

  static {
    try {
      Field field = Unsafe.class.getDeclaredField("theUnsafe");
      field.setAccessible(true);
      unsafe = (Unsafe) field.get(null);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    test_memory();
  }

  public static void test_memory() {
    long byteAddr = 0;
    try {
      byteAddr = unsafe.allocateMemory(8);
      byte val = (byte) 255;
      unsafe.putByte(byteAddr, val);
      byte ub = unsafe.getByte(byteAddr);

      assertEquals(val, ub);
    } finally {
      if (byteAddr != 0) {
        unsafe.freeMemory(byteAddr);
      }
    }
  }
}
