# 1. design

日期: 2021-04-01

## 状态

2021-04-01 提议

## 背景

在这里补充上下文...

IDEA 2

- [ ] Intellij IDEA Community Debugger 是否支持 JavaScript。Rust 官方显示的是不支持

对比：https://www.jetbrains.com/idea/features/editions_comparison_matrix.html


DLanguage 通过 GDB 实现：https://github.com/intellij-dlanguage/intellij-dlanguage

参考 VSCode，使用 JavaScript LSP 用于 Debugger，示例：https://github.com/microsoft/vscode-js-debug  + 微信的 Debug Adapter Protocol -> https://microsoft.github.io/debug-adapter-protocol/

DartLang -> https://github.com/dart-lang/sdk/issues/35717


三种方式：

1. 反编译。参考 Intellij IDEA 的调用机制？如语法解析等。
2. 参考其它语言，如 Rust
3. 采用 VSCode 的 debug 机制，DAPR


Node.js Debug: https://nodejs.org/en/docs/guides/debugging-getting-started/

Node Inspect: https://github.com/nodejs/node-inspect

Jest Debug: https://github.com/flutter/flutter-intellij

Mocha Debug 开源：https://github.com/JetBrains/mocha-intellij

Samples: https://github.com/puremourning/vimspector



## 决策

在这里补充上决策信息...

## 后果

在这里记录结果...
