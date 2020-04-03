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

# 相关记录
- TBD 源码分析环境搭建
- TBD 源码注释规范

# 变更日志
- 200403 初始化
