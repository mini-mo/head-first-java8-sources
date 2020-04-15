# Head First Java8 Sources
一头扎进 Java8 标准库源码  
试图研读标准库源码而搭建的源码分析项目

# 分析环境
- macos
- openjdk version "1.8.0_242"
- idea 2019.3

# 目录结构
```bash
├── doc # 相关分析记录
├── src # 源码
│   └── java
│       ├── io
│       ├── lang
│       │   ├── annotation
│       │   ├── instrument
│       │   ├── invoke
│       │   ├── management
│       │   ├── ref
│       │   └── reflect
│       ├── math
│       ├── net
│       ├── nio
│       │   ├── channels
│       │   │   └── spi
│       │   ├── charset
│       │   │   └── spi
│       │   └── file
│       │       ├── attribute
│       │       └── spi
│       ├── text
│       │   └── spi
│       ├── time
│       │   ├── chrono
│       │   ├── format
│       │   ├── temporal
│       │   └── zone
│       └── util
│           ├── concurrent
│           │   ├── atomic
│           │   └── locks
│           ├── function
│           ├── jar
│           ├── logging
│           ├── prefs
│           ├── regex
│           ├── spi
│           ├── stream
│           └── zip
└── tests # 测试代码
    └── util 
```

# 分析进度
## java.lang 包
### 基本类型包装类
- java.lang.Boolean   -> TODO
- java.lang.Character -> TODO
- java.lang.Byte      -> TODO
- java.lang.Short     -> TODO
- ✅ [java.lang.Integer](doc/java.lang.Integer.md)
- java.lang.Long      -> TODO
- java.lang.Float     -> TODO
- java.lang.Double    -> TODO

### String 相关
- [java.lang.String](doc/java.lang.String.md)  -> TODO

### Object 相关
- [java.lang.Object](doc/java.lang.Object.md)  -> TODO

### System 相关
- [java.lang.System](doc/java.lang.System.md)  -> TODO

### Thread 相关
- [java.lang.Thread](doc/java.lang.Thread.md)  -> TODO

## java.io 包

## java.nio 包

## java.net 包

## java.time 包

## java.util 基本数据结构

## java.util.concurrent 包

## java.util.regex 包

## java.util.function 包

## java.util.stream 包

## java.util.logging 包

# 相关记录
- ✅ [源码分析环境搭建](doc/analysis-env-setup.md)
- ✅ [源码注释规范](doc/annotaion-spec.md)

# 变更日志
- 200406 java.lang.IntegerTest
- 200403 初始化
