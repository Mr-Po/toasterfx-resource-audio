# ToasterFX 音效资源 [![language: English](https://img.shields.io/badge/-English-blue?style=social&logo=markdown)](README_en.md)

[![Build Status](https://travis-ci.com/Mr-Po/toasterfx-resource-audio.svg?branch=master)](https://travis-ci.com/Mr-Po/toasterfx-resource-audio)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/github/Mr-Po/toasterfx-resource-audio?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/Mr-Po/toasterfx-resource-audio/context:java)
[![Maven Central](https://img.shields.io/maven-central/v/com.gitee.pomo/toasterfx-resource-audio/1)](https://search.maven.org/#search|ga|1|com.gitee.pomo.toasterfx-resource-audio)

[![Apache License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](LICENSE)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2FMr-Po%2Ftoasterfx-resource-audio.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2FMr-Po%2Ftoasterfx-resource-audio?ref=badge_shield)

[ToasterFX](../../../toasterfx) 的一个音效资源库。

## 特性
* 提供了随机气泡音

## 安装

Maven：
```xml
<dependency>
    <groupId>com.gitee.pomo</groupId>
    <artifactId>toasterfx-resource-audio</artifactId>
    <version>1.0.2</version>
</dependency>
```

Gradle：
```groovy
compile group: 'com.gitee.pomo', name: 'toasterfx-resource-audio', version: '1.0.2'
```

## 使用
```java
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