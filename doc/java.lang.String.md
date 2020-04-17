---
状态： 完善中
---

## 概览
出镜率和基本类型一样高的核心数据结构，可以没有 boolean , 但是不能没有 String. 帝国基石。  

## 常见用法
[测试类](../tests/lang/StringTest.java)
```java
int length = "test".length();
assertEquals(4, length);

boolean bc = "test".contains("tes");
assertEquals(true, bc);

boolean bs = "test".startsWith("tes");
assertEquals(true, bs);

boolean be = "test".endsWith("st");
assertEquals(true, be);

char cc = "test".charAt(3);
assertEquals('t', cc);

int ii = "test".indexOf('e');
assertEquals(1, ii);

java.lang.StringTest trim = " test ".trim();
assertEquals("test", trim);

java.lang.StringTest[] es = "test".split("e");
assertEquals(2, es.length);
assertEquals("t", es[0]);
assertEquals("st", es[1]);

java.lang.StringTest substring = "test".substring(1, 2);
assertEquals("e", substring);

java.lang.StringTest uc = "test".toUpperCase();
assertEquals("TEST", uc);

java.lang.StringTest lc = "tEst".toLowerCase();
assertEquals("test", lc);

java.lang.StringTest replace = "test".replace("te", "T");
assertEquals("Tst", replace);

java.lang.StringTest ra = "stest".replaceAll(".{2}t", "T");
assertEquals("stT", ra);

java.lang.StringTest test = java.lang.StringTest.join(",", "x", "y", "z");
assertEquals("x,y,z", test);

java.lang.StringTest j2 = java.lang.StringTest.join(",", Arrays.asList("x", "y", "z"));
assertEquals("x,y,z", j2);

```

## 继承结构
![java.lang.String](java.lang.String.png)
## 主要属性
### 成员变量
```java
/** The value is used for character storage. */
private final char value[]; // 字符数组， 存储字符

/** Cache the hash code for the string */
private int hash; // Default to 0 // 性能优化， String 的实现是不可变的， 生命周期内 hash 也是不会变得， 不用每次计算。 
```
### 静态变量
```java
/** use serialVersionUID from JDK 1.0.2 for interoperability */
private static final long serialVersionUID = -6849794470754667710L;

/**
 * Class String is special cased within the Serialization Stream Protocol.
 *
 * A String instance is written into an ObjectOutputStream according to
 * <a href="{@docRoot}/../platform/serialization/spec/output.html">
 * Object Serialization Specification, Section 6.2, "Stream Elements"</a>
 */
private static final ObjectStreamField[] serialPersistentFields =
    new ObjectStreamField[0]; 与序列化有关， 后续分析序列化时再详细分析
```

## 主要方法
### 构造函数
```java
/**
 * Initializes a newly created {@code String} object so that it represents
 * an empty character sequence.  Note that use of this constructor is
 * unnecessary since Strings are immutable.
 */
public String() {
    this.value = "".value;
}

/**
 * Constructs a new {@code String} by decoding the specified subarray of
 * bytes using the specified {@linkplain java.nio.charset.Charset charset}.
 * The length of the new {@code String} is a function of the charset, and
 * hence may not be equal to the length of the subarray.
 *
 * <p> This method always replaces malformed-input and unmappable-character
 * sequences with this charset's default replacement string.  The {@link
 * java.nio.charset.CharsetDecoder} class should be used when more control
 * over the decoding process is required.
 *
 * @param  bytes
 *         The bytes to be decoded into characters
 *
 * @param  offset
 *         The index of the first byte to decode
 *
 * @param  length
 *         The number of bytes to decode
 *
 * @param  charset
 *         The {@linkplain java.nio.charset.Charset charset} to be used to
 *         decode the {@code bytes}
 *
 * @throws  IndexOutOfBoundsException
 *          If the {@code offset} and {@code length} arguments index
 *          characters outside the bounds of the {@code bytes} array
 *
 * @since  1.6
 */
public String(byte bytes[], int offset, int length, Charset charset) {
    if (charset == null)
        throw new NullPointerException("charset");
    checkBounds(bytes, offset, length);
    this.value =  StringCoding.decode(charset, bytes, offset, length);
}

```
### 实例方法


### 静态方法

## 常见问题
### 平时开发都是直接 ```String x = "xxx"```，没有使用 ```String x = new String("xxx") ``` ， 这两种方式有啥区别，怎么选择？
结论，使用 String x = "xxx"  
通过反编译字节码可以看出两种方式的区别， 示例如下  
```java
public class StringInit {
  public static void main(String[] args) {
    String x = "test";

    String y = new String("test");
  }
}
```
反编译如下  
```bash
 0: ldc           #2                  // String test
 2: astore_1
 3: new           #3                  // class java/lang/String
 6: dup
 7: ldc           #2                  // String test
 9: invokespecial #4                  // Method java/lang/String."<init>":(Ljava/lang/String;)V
12: astore_2
13: return

# ------

# String x = "test" ， 对应两条指令
       0: ldc           #2                  // String test
       2: astore_1
ldc 从常量池加载字符串 test 到操作数栈栈顶
astore_1 把操作数栈栈顶数据存到本地变量表 1 

# String y = new String("test"), 对应 5 条指令，还包含一个方法执行指令。
       3: new           #3                  // class java/lang/String
       6: dup
       7: ldc           #2                  // String test
       9: invokespecial #4                  // Method java/lang/String."<init>":(Ljava/lang/String;)V
      12: astore_2
new 新建 String 实例，置于操作数栈栈顶。
dup 复制操作数栈栈顶数据，并置于操作数栈栈顶
ldc 从常量池加载字符串 test 到操作数栈栈顶
invokespecial 执行构造方法， 对应 String(String x). 会消耗掉操作数栈顶的一个 String 实例。 
astore_2 把操作数栈栈顶数据存到本地变量表 2
```
从上面的反编译字节码可以看出 String x = "xxx" 的效率更高。   
**画外音** 总是不可避免的和字节码打交道, 就是写 C 语言不可避免的和 ASM 打交道一样。 

### ```"xxx" + "yyy"``` 是什么魔法？ 如果用过 C 语言，会发现字符串不能直接相加。  
>The Java language provides special support for the string
>concatenation operator (&nbsp;+&nbsp;), and for conversion of
>other objects to strings. String concatenation is implemented
>through the {@code StringBuilder}(or {@code StringBuffer})
>class and its {@code append} method.

还是编译器的魔法，编译期使用 StringBuilder append 构建的。 这是 Java 里唯一的运算符重载。 
源码  
```java
public class StringPlus {
  public static void main(String[] args) {
    String a = "aaa";
    String b = "bbb";
    String c = a + b;
  }
}
```
反编译  
```bash
 0: ldc           #2                  // String aaa
 2: astore_1
 3: ldc           #3                  // String bbb
 5: astore_2
 6: new           #4                  // class java/lang/StringBuilder
 9: dup
10: invokespecial #5                  // Method java/lang/StringBuilder."<init>":()V
13: aload_1
14: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
17: aload_2
18: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
21: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
24: astore_3
25: return

```
反编译的代码等价于如下代码
```java
public class StringPlus {
  public static void main(String[] args) {
    String arg1 = "aaa";
    String arg2 = "bbb";
    String arg3 = new StringBuilder().append(args1).append(args2).toString();
  }
}
```

### String 的不变性，什么是不可变类，不可变类意味着什么，怎么实现不可变类, 为什么要设计为不可变类，

- 不可变类只是其实例不能被修改的类。每个实例中包含的所有信息都必须在创建该实例的时候就提供，并且在对象的整个生命周期内固定不变。  
- 不可变类意味着实例创建后，实例的状态不能被改变。 
- 怎么实现不可变类
  - 不要提供任何会修改对象状态的方法。 String 类方法不会改变自身状态，通常会返回新的字符串
  - 保证类不会被扩展。 String 类声明为 final, 无法被继承
  - 保证属性为 final， 除构造方法外， 无法被修改。 
  - 保证属性为私有， 外部无法直接访问。
- String 为什么要设计为不可变类
  - String 被类似类加载器等虚拟机核心机制依赖
  - String 的定位和基础类型的包装类一致, 不可变符合直觉
  - 不可变无副作用，集合业务，并发业务可无负担使用。

###  关于 String intern 方法。  
建议不用深究， 意义不大，在几个主流代码库（spring, netty, dubbo) 搜索均没有该方法的使用。  

### [Switch](https://docs.oracle.com/javase/specs/jls/se8/html/jls-14.html#jls-14.11) 语句与 String  
> The type of the Expression must be char, byte, short, int, Character, Byte, Short, Integer, String, or an enum type (§8.9), or a compile-time error occurs.

JDK 1.7 的新特性，编译器做的手脚，可以通过反编译一探究竟
```java
public class StringSwitch {
  public static void main(String[] args) {
    String test = "test";
    int result = 0;
    switch (test){
     case "test":
        result = 1;
        break;
     case "test2":
        result = 2;
        break;
      default:
        break;
    }
  }
}
```
反编译代码如下  
```bash
  0: ldc           #2                  // String test
  2: astore_1
  3: iconst_0
  4: istore_2
  5: aload_1
  6: astore_3
  7: iconst_m1
  8: istore        4
 10: aload_3
 11: invokevirtual #3                  // Method java/lang/String.hashCode:()I
 14: lookupswitch  { // 2
       3556498: 40
     110251488: 55
       default: 67
    }
 40: aload_3
 41: ldc           #2                  // String test
 43: invokevirtual #4                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
 46: ifeq          67
 49: iconst_0
 50: istore        4
 52: goto          67
 55: aload_3
 56: ldc           #5                  // String test2
 58: invokevirtual #4                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
 61: ifeq          67
 64: iconst_1
 65: istore        4
 67: iload         4
 69: lookupswitch  { // 2
             0: 96
             1: 101
       default: 106
   }
 96: iconst_1
 97: istore_2
 98: goto          106
101: iconst_2
102: istore_2
103: goto          106
106: return
```
可以看到最终转化成 lookupswitch 指令。  
3556498 是字符串 "test" 的 hashCode  
110251488 是字符串 "test2" 的 hashCode  

最终还是使用了 int 来实现 switch 的。 处理方式跟对 enum 类型支持是一样的。 

## 补充
### String 的不变性可以通过反射绕过。 
```java
  // 改变字符串
  private static void test_reflection() {
    String test = "test";
    try {
      Field filed = String.class.getDeclaredField("value");
      filed.setAccessible(true);
      char[] val = (char[]) filed.get(test);
      val[0] = 'T';
      assertEquals("Test", test);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }
```

## 后记
1. 暂不分析 native 方法实现
2. 一家之言， 难免疏忽

## 参考
- [JDK 之 String 源码阅读笔记](https://emacsist.github.io/2017/07/01/jdk-%E4%B9%8B-string-%E6%BA%90%E7%A0%81%E9%98%85%E8%AF%BB%E7%AC%94%E8%AE%B0/)
- [String源码分析](https://juejin.im/post/59fffddc5188253d6816f9c1)
- [深入解析String#intern](https://tech.meituan.com/2014/03/06/in-depth-understanding-string-intern.html)
- [String 为什么不可变 ?](https://juejin.im/post/59cef72b518825276f49fe40)
