# ToasterFX 音效资源 [![language: English](https://img.shields.io/badge/language-English-brightgreen)](README_en.md)

[![toasterfx: 1.0.2+](https://img.shields.io/badge/toasterfx-1.0.2%2B-green)](../../../toasterfx)
[![Build Status](https://travis-ci.com/Mr-Po/toasterfx-resource-audio.svg?branch=master)](https://travis-ci.com/Mr-Po/toasterfx-resource-audio)
[![Apache License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](LICENSE)

[ToasterFX](../../../toasterfx) 的一个音效资源库。

## 特性
* 提供了随机气泡音

## 安装
Maven：
```
<dependency>
    <groupId>com.gitee.pomo</groupId>
    <artifactId>toasterfx-resource-audio</artifactId>
    <version>1.0.2</version>
</dependency>
```
Gradle：
```
compile group: 'com.gitee.pomo', name: 'toasterfx-resource-audio', version: '1.0.2'
```

## 使用
```
ToastBarToasterService service = new ToastBarToasterService();
service.initialize();

// 定义了一个随机音效的消息体属性。
ToastParameter parameter = ToastParameter.builder()
                .audio(RandomBubbleAudio.DEFAULT)
                .build();

// 你可以在任何线程中，调用此方法。
service.bomb("ToasterFX","Hello ToasterFX !",parameter,ToastTypes.INFO);
```
## 截图
![0990E73E5E9874011F4714F9AE73E146.gif](https://i.loli.net/2020/09/28/RPShGny2mKedi5r.gif)

更多特性及样例请访问：[ToasterFX-DEMO](../../../toasterfx-demo)。