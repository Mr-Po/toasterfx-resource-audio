# ToasterFX Audio Resource [![语言：中文](https://img.shields.io/badge/-%E4%B8%AD%E6%96%87-blue?style=social&logo=markdown)](README.md)

[![Build Status](https://travis-ci.com/Mr-Po/toasterfx-resource-audio.svg?branch=master)](https://travis-ci.com/Mr-Po/toasterfx-resource-audio)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/github/Mr-Po/toasterfx-resource-audio?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/Mr-Po/toasterfx-resource-audio/context:java)
[![codecov](https://codecov.io/gh/Mr-Po/toasterfx-resource-audio/branch/master/graph/badge.svg)](https://codecov.io/gh/Mr-Po/toasterfx-resource-audio)
[![Maven Central](https://img.shields.io/maven-central/v/com.gitee.pomo/toasterfx-resource-audio)](https://search.maven.org/#search|ga|1|com.gitee.pomo.toasterfx-resource-audio)

[![License](https://img.shields.io/github/license/Mr-Po/toasterfx-resource-audio?color=blue)](LICENSE)
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2FMr-Po%2Ftoasterfx-resource-audio.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2FMr-Po%2Ftoasterfx-resource-audio?ref=badge_shield)

An audio resource library of [ToasterFX](../../../toasterfx).

## Features
* With the audio of random bubble

## Installation

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

## Usage
```java
ToastBarToasterService service = new ToastBarToasterService();
service.initialize();

// The toast paramter of a random audio is defined.
ToastParameter parameter = ToastParameter.builder()
                .audio(RandomBubbleAudio.DEFAULT)
                .build();

// You can call this method on any thread.
service.bomb("ToasterFX","Hello ToasterFX !",parameter,ToastTypes.INFO);
```
## Screenshot
![0990E73E5E9874011F4714F9AE73E146.gif](https://i.loli.net/2020/09/28/RPShGny2mKedi5r.gif)

For more features and sample demo：[ToasterFX-DEMO](../../../toasterfx-demo).