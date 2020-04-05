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
### 8 个包装类
- java.lang.Boolean   -> TODO
- java.lang.Character -> TODO
- java.lang.Byte      -> TODO
- java.lang.Short     -> TODO
- [java.lang.Integer](doc/java.lang.Integer.md)   -> DONIG
- java.lang.Long      -> TODO
- java.lang.Float     -> TODO
- java.lang.Double    -> TODO

### String 相关

### Object 相关

### System 相关

# 相关记录
- TBD 源码分析环境搭建
- [源码注释规范](doc/源码注释规范.md) -> TBD

# 变更日志
- 200403 初始化
